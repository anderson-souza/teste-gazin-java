package com.andersonsouza.testegazin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Atuacao;
import com.andersonsouza.testegazin.repository.AtuacaoRepository;
import com.andersonsouza.testegazin.services.exception.AtuacaoNaoEncontradoException;

@Service
public class AtuacaoService {

	@Autowired
	AtuacaoRepository atuacaoRepository;

	private final AtorService atorService;

	@Autowired
	public AtuacaoService(AtorService atorService) {
		this.atorService = atorService;
	}

	public List<Atuacao> listar() {
		return (List<Atuacao>) atuacaoRepository.findAll();
	}

	public Atuacao buscar(Long id) {
		Optional<Atuacao> atuacao = atuacaoRepository.findById(id);

		if (atuacao.isEmpty()) {
			throw new AtuacaoNaoEncontradoException();
		}
		return atuacao.get();
	}

	public void salvar(Atuacao atuacao) {
		atuacao.setId(null);
		atorService.buscar(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void atualizar(long id, Atuacao atuacao) {
		atuacao.setId(id);
		verificarExistencia(id);
		atorService.buscar(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void deletar(long id) {
		verificarExistencia(id);
		atuacaoRepository.deleteById(id);

	}

	private void verificarExistencia(Long id) {
		buscar(id);
	}

}
