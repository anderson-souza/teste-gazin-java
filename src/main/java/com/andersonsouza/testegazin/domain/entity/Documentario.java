package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Documentario extends Filme {

	private Long id;
	private String assunto;

}
