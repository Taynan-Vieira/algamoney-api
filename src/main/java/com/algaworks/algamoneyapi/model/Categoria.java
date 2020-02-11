package com.algaworks.algamoneyapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Getter
	@Setter
	private String nome;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Categoria categoria = (Categoria) o;
		return Objects.equals(codigo, categoria.codigo) && Objects.equals(nome, categoria.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}
}
