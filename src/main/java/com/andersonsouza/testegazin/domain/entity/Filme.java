package com.andersonsouza.testegazin.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("F")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Título é obrigatório")
	private String titulo;

	private BigDecimal verba;
	private Date dtGravacaoInicio;
	private Date dtGravacaoFim;

	@OneToOne
	private Ator ator;

	@NotNull(message = "Diretor é obrigatório")
	@ManyToOne
	private Diretor diretor;

	@NotNull(message = "Produtor é obrigatório")
	@ManyToOne
	private Produtor produtor;

	@OneToMany
	@NotNull(message = "Atuação é obrigatório")
	private List<Atuacao> atuacao;

}
