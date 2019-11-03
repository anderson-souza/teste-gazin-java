package com.andersonsouza.testegazin.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Título é obrigatório")
	private String titulo;

	private BigDecimal verba;
	private Date dtGravacaoInicio;
	private Date dtGravacaoFim;

	private Ator ator;

	@NotNull(message = "Diretor é obrigatório")
	private Diretor diretor;

	@NotNull(message = "Produtor é obrigatório")
	private Produtor produtor;

	@OneToMany
	@NotNull(message = "Atuação é obrigatório")
	private List<Atuacao> atuacao;

}