package com.andersonsouza.testegazin.services;

import java.util.List;
import java.util.Optional;

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

	public Ator buscar(Long id) {
		Optional<Ator> ator = atorRepository.findById(id);

		if (ator.isEmpty()) {
			throw new AtorNaoEncontradoException();
		}
		return ator.get();
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

	private void verificaExistencia(Long id) {
		buscar(id);
	}

}
