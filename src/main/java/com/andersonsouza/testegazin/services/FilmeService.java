package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Filme;
import com.andersonsouza.testegazin.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	@Autowired
	DiretorService diretorService;
	@Autowired
	ProdutorService produtorService;
	@Autowired
	AtuacaoService atuacaoService;
	@Autowired
	AtorService atorService;

	public List<Filme> listar() {
		return (List<Filme>) filmeRepository.findAll();
	}

	public void salvar(Filme filme) {
		filme.setId(null);

		filmeRepository.save(filme);
	}

	public void atualizar(long id, Filme filme) {
		filme.setId(id);
		// verificaExistencia(id);
		filmeRepository.save(filme);
	}

	public void deletar(long id) {
		// verificaExistencia(id);
		filmeRepository.deleteById(id);
	}

}
