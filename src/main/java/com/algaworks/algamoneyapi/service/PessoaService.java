package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {

		Pessoa pessoaSalva = buscaPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return this.pessoaRepository.save(pessoaSalva);
	}

	public Pessoa atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoa = buscaPessoaPeloCodigo(codigo);
		pessoa.setAtivo(ativo);
		return pessoaRepository.save(pessoa);
	}

	private Pessoa buscaPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoaSalva = Optional.ofNullable(pessoaRepository.findById(codigo))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return pessoaSalva.get();
	}

}
