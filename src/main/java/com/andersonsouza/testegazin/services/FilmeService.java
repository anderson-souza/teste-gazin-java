package com.andersonsouza.testegazin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonsouza.testegazin.domain.entity.Filme;
import com.andersonsouza.testegazin.repository.FilmeRepository;
import com.andersonsouza.testegazin.services.exception.FilmeNaoEncontradoException;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	private final DiretorService diretorService;
	private final ProdutorService produtorService;
	private final AtuacaoService atuacaoService;
	private final AtorService atorService;

	@Autowired
	public FilmeService(DiretorService diretorService, ProdutorService produtorService, AtuacaoService atuacaoService,
			AtorService atorService) {
		this.diretorService = diretorService;
		this.produtorService = produtorService;
		this.atuacaoService = atuacaoService;
		this.atorService = atorService;
	}

	public List<Filme> listar() {
		return (List<Filme>) filmeRepository.findAll();
	}

	public Filme buscar(Long id) {
		Optional<Filme> filme = filmeRepository.findById(id);

		if (filme.isEmpty()) {
			throw new FilmeNaoEncontradoException();
		}
		return filme.get();
	}

	public void salvar(Filme filme) {
		filme.setId(null);

		diretorService.buscar(filme.getDiretor().getId());
		produtorService.buscar(filme.getProdutor().getId());
		filme.getAtuacao().forEach(a -> atuacaoService.buscar(a.getId()));

		if (filme.getAtor() != null) {
			atorService.buscar(filme.getAtor().getId());
		}

		filmeRepository.save(filme);
	}

	public void atualizar(long id, Filme filme) {
		filme.setId(id);
		verificaExistencia(id);
		filmeRepository.save(filme);
	}

	public void deletar(long id) {
		verificaExistencia(id);
		filmeRepository.deleteById(id);
	}

	public void verificaExistencia(Long id) {
		buscar(id);
	}

}
