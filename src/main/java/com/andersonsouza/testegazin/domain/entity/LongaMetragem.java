package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class LongaMetragem extends Filme {

	private Long id;
	private String categoria;

}
