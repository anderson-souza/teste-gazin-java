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

	@Autowired
	AtorService atorService;

	public List<Atuacao> listar() {
		return (List<Atuacao>) atuacaoRepository.findAll();
	}

	public void salvar(Atuacao atuacao) {
		atuacao.setId(null);
		atuacaoRepository.save(atuacao);
	}

	public void atualizar(long id, Atuacao atuacao) {
		atuacao.setId(id);
		verificarExistencia(id);
		atorService.verificaExistencia(atuacao.getAtor().getId());
		atuacaoRepository.save(atuacao);
	}

	public void deletar(long id) {
		verificarExistencia(id);
		atuacaoRepository.deleteById(id);

	}

	private void verificarExistencia(Long id) {
		buscar(id);
	}

	public Atuacao buscar(Long id) {
		Optional<Atuacao> atuacao = atuacaoRepository.findById(id);

		if (atuacao.isEmpty()) {
			throw new AtuacaoNaoEncontradoException();
		}
		return atuacao.get();
	}

}
