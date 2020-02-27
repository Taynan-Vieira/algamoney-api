package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {

		Optional pessoaSalva = this.pessoaRepository.findById(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return this.pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		ResponseEntity<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}

	public ResponseEntity buscarPessoaPeloCodigo(Long codigo) {
		Optional pessoaSalva = pessoaRepository.findById(codigo);
		return pessoaSalva.isPresent() ? ResponseEntity.ok(pessoaSalva.get()) : ResponseEntity.notFound();
	}
}
