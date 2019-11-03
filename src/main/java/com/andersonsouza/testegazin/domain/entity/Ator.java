package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Nome é obrigatório")
	private String nome;

	@Email(message = "Informar um e-mail válido")
	private String email;
	private String telefone;

}
