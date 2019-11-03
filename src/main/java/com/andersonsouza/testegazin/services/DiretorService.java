package com.andersonsouza.testegazin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Diretor;
import com.andersonsouza.testegazin.repository.DiretorRepository;

@Service
public class DiretorService {

	@Autowired
	DiretorRepository diretorRepository;

	public List<Diretor> listar() {
		return (List<Diretor>) diretorRepository.findAll();
	}

	public void salvar(Diretor diretor) {
		diretor.setId(null);
		diretorRepository.save(diretor);
	}

	public void atualizar(long id, Diretor diretor) {
		diretor.setId(id);
		// verificaExistencia(id);
		diretorRepository.save(diretor);
	}

	public void deletar(long id) {
		// verificaExistencia(id);
		diretorRepository.deleteById(id);

	}

	public void verificaExistencia(Long id) {
		// buscar(id);
	}

}
