package com.algaworks.algamoneyapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "descricao")
	@NotNull
	private String descricao;

	@Column(name = "data_vencimento")
	@NotNull
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;

	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoLancamento tipoLancamento;

	@JoinColumn(name = "codigo_categoria")
	@ManyToOne
	@NotNull
	private Categoria categoria;

	@JoinColumn(name = "codigo_pessoa")
	@ManyToOne
	@NotNull
	private Pessoa pessoa;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lancamento that = (Lancamento) o;
		return Objects.equals(codigo, that.codigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
}
