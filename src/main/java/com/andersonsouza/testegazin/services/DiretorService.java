package com.andersonsouza.testegazin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Diretor;
import com.andersonsouza.testegazin.repository.DiretorRepository;
import com.andersonsouza.testegazin.services.exception.DiretorNaoEncontradoException;

@Service
public class DiretorService {

	@Autowired
	DiretorRepository diretorRepository;

	public List<Diretor> listar() {
		return (List<Diretor>) diretorRepository.findAll();
	}

	public Diretor buscar(Long id) {
		Optional<Diretor> diretor = diretorRepository.findById(id);

		if (diretor.isEmpty()) {
			throw new DiretorNaoEncontradoException();
		}
		return diretor.get();
	}

	public void salvar(Diretor diretor) {
		diretor.setId(null);
		diretorRepository.save(diretor);
	}

	public void atualizar(long id, Diretor diretor) {
		diretor.setId(id);
		verificaExistencia(id);
		diretorRepository.save(diretor);
	}

	public void deletar(long id) {
		verificaExistencia(id);
		diretorRepository.deleteById(id);

	}

	public void verificaExistencia(Long id) {
		buscar(id);
	}

}
