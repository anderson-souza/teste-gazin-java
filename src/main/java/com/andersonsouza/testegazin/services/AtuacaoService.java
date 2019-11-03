package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Atuacao;
import com.andersonsouza.testegazin.repository.AtuacaoRepository;
import com.andersonsouza.testegazin.services.exception.AtuacaoNaoEncontradoException;

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
		atorService.verificaExistencia(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void atualizar(long id, Atuacao atuacao) {
		atuacao.setId(id);
		verificaExistencia(id);
		atorService.verificaExistencia(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void deletar(long id) {
		verificaExistencia(id);
		atuacaoRepository.deleteById(id);
	}

	public void verificaExistencia(Long id) {
		if (atuacaoRepository.findById(id).isPresent()) {
			throw new AtuacaoNaoEncontradoException();
		}
	}

}
