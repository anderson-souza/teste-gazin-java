package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Atuacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Papel é obrigatório")
	private String papel;

	@ManyToOne
	@NotNull(message = "Ator é obrigatório")
	private Ator ator;

}
