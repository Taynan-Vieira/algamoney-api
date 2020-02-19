package com.algaworks.algamoneyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 3, max= 50)
	@Getter
	@Setter
	@Column(name = "nome")
	private String nome;

	@Embedded
	@Getter
	@Setter
	private Endereco endereco;

	@Getter
	@Setter
	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@JsonIgnore
	@Transient
	public boolean isInativo(){
		return !this.ativo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(codigo, pessoa.codigo) && Objects.equals(nome, pessoa.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}
}
