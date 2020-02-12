package com.algaworks.algamoneyapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@Getter
	@Setter
	@NotNull
	private Long codigo;

	@NotNull
	@Size(min = 3, max= 50)
	private String nome;

	@Getter
	@Setter
	@NotNull
	private Boolean ativo;

	@Embedded
	private Endereco endereco;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pessoa pessoa = (Pessoa) o;
		return codigo.equals(pessoa.codigo) && ativo.equals(pessoa.ativo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, ativo);
	}
}
