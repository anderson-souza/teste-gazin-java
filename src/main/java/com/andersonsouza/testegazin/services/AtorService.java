package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Ator;
import com.andersonsouza.testegazin.repository.AtorRepository;
import com.andersonsouza.testegazin.services.exception.AtorNaoEncontradoException;

@Service
public class AtorService {

	@Autowired
	AtorRepository atorRepository;

	public List<Ator> listar() {
		return (List<Ator>) atorRepository.findAll();
	}

	public void salvar(Ator ator) {
		ator.setId(null);
		atorRepository.save(ator);
	}

	public void atualizar(long id, Ator ator) {
		ator.setId(id);
		verificaExistencia(id);
		atorRepository.save(ator);

	}

	public void deletar(long id) {
		verificaExistencia(id);
		atorRepository.deleteById(id);

	}

	public void verificaExistencia(Long id) {
		if (atorRepository.findById(id).isEmpty()) {
			throw new AtorNaoEncontradoException();
		}
	}

}
