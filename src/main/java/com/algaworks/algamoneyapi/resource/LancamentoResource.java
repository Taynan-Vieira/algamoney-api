package com.algaworks.algamoneyapi.resource;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.exceptionhandler.AlgamoneyExceptionHandler;
import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.service.LancamentoService;
import com.algaworks.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private LancamentoService lancamentoService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public Page<Lancamento> listarLancamentos(Pageable pageable){
		return lancamentoRepository.findAll(pageable);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity buscarPorCodigo(@PathVariable Long codigo) {
		Optional lancamento = this.lancamentoRepository.findById(codigo);
		return lancamento.isPresent() ?
				ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Lancamento> criarLancamento(@Valid @RequestBody Lancamento lancamento,
	                                                  HttpServletResponse response) {
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);

	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerLancamento(@PathVariable Long codigo){
		lancamentoRepository.delete(lancamento);
	}

	@ExceptionHandler({PessoaInexistenteOuInativaException.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex){
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null,
		                                                  LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor =  ex.toString();
		List erros = Arrays
				.asList(new AlgamoneyExceptionHandler.Erro[]
						        {new AlgamoneyExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor)});

		return ResponseEntity.badRequest().body(erros);
	}


}
