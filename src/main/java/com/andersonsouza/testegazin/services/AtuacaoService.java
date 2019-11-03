package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Atuacao;
import com.andersonsouza.testegazin.repository.AtuacaoRepository;

@Service
public class AtuacaoService {

	@Autowired
	AtuacaoRepository atuacaoRepository;

	@Autowired
	AtorService atorService;

	public List<Atuacao> listar() {
		return (List<Atuacao>) atuacaoRepository.findAll();
	}

	public void salvar(Atuacao atuacao) {
		atuacao.setId(null);
		// atorService.buscar(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void atualizar(long id, Atuacao atuacao) {
		atuacao.setId(id);
		// verificarExistencia(id);
		// atorService.buscar(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void deletar(long id) {
		// verificarExistencia(id);
		atuacaoRepository.deleteById(id);

	}
}
