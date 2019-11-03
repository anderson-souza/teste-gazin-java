package com.andersonsouza.testegazin.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersonsouza.testegazin.domain.entity.Atuacao;
import com.andersonsouza.testegazin.services.AtuacaoService;

@RestController
public class AtuacaoResource {

	@Autowired
	AtuacaoService atuacaoService;

	private static final String PATH = "/atuacao";

	@GetMapping(PATH)
	public List<Atuacao> listar() {
		return atuacaoService.listar();
	}

	@PostMapping(PATH)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Atuacao atuacao) {
		atuacaoService.salvar(atuacao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(atuacao.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(PATH + "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Atuacao atuacao, @PathVariable long id) {
		atuacaoService.atualizar(id, atuacao);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(PATH + "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		atuacaoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
