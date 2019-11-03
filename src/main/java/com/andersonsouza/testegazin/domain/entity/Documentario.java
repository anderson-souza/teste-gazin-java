package com.andersonsouza.testegazin.domain.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Documentario extends Filme {

	private Long id;
	private String assunto;

}
