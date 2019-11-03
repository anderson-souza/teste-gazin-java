package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Produtor;
import com.andersonsouza.testegazin.repository.ProdutorRepository;

@Service
public class ProdutorService {

	@Autowired
	ProdutorRepository produtorRepository;

	public List<Produtor> listar() {
		return (List<Produtor>) produtorRepository.findAll();
	}

}
