package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "L")
public class LongaMetragem extends Filme {

	private Long id;
	private String categoria;

}
