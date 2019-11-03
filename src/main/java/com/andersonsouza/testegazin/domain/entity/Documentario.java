package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "D")
public class Documentario extends Filme {

	private Long id;
	private String assunto;

}
