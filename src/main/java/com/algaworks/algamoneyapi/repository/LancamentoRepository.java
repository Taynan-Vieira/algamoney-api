package com.algaworks.algamoneyapi.repository;

import com.algaworks.algamoneyapi.model.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Override
	Page<Lancamento> findAll(Pageable pageable);

}
