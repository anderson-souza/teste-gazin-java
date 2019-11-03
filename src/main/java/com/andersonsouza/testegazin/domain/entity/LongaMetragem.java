package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LongaMetragem extends Filme {

	private Long id;
	private String categoria;

}
