package com.andersonsouza.testegazin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Produtor;
import com.andersonsouza.testegazin.repository.ProdutorRepository;
import com.andersonsouza.testegazin.services.exception.ProdutorNaoEncontradoException;

@Service
public class ProdutorService {

	@Autowired
	ProdutorRepository produtorRepository;

	public List<Produtor> listar() {
		return (List<Produtor>) produtorRepository.findAll();
	}

	public Produtor buscar(Long id) {
		Optional<Produtor> produtor = produtorRepository.findById(id);

		if (produtor.isEmpty()) {
			throw new ProdutorNaoEncontradoException();
		}
		return produtor.get();
	}

	public void salvar(Produtor produtor) {
		produtor.setId(null);
		produtorRepository.save(produtor);
	}

	public void atualizar(long id, Produtor produtor) {
		produtor.setId(id);
		verificaExistencia(id);
		produtorRepository.save(produtor);

	}

	public void deletar(long id) {
		verificaExistencia(id);
		produtorRepository.deleteById(id);

	}

	private void verificaExistencia(Long id) {
		buscar(id);
	}

}
