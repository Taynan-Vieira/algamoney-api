package com.algaworks.algamoneyapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 3, max= 50)
	@Getter
	@Setter
	private String nome;

	@Embedded
	@Getter
	@Setter
	private Endereco endereco;

	@Getter
	@Setter
	@NotNull
	private Boolean ativo;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(codigo, pessoa.codigo) && Objects.equals(nome, pessoa.nome) &&
				Objects.equals(endereco, pessoa.endereco) && Objects.equals(ativo, pessoa.ativo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, endereco, ativo);
	}
}
