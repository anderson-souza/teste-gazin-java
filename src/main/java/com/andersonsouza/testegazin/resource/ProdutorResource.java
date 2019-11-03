package com.andersonsouza.testegazin.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonsouza.testegazin.domain.entity.Produtor;
import com.andersonsouza.testegazin.services.ProdutorService;

@RestController
public class ProdutorResource {

	@Autowired
	ProdutorService produtorService;

	static final String mapping = "/produtor";

	@GetMapping(path = "/V1" + mapping, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Produtor> listar() {
		return produtorService.listar();
	}

}
