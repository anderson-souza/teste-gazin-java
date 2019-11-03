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

import com.andersonsouza.testegazin.domain.entity.Filme;
import com.andersonsouza.testegazin.services.FilmeService;

@RestController
public class FilmeResource {

	@Autowired
	FilmeService filmeService;

	private static final String PATH = "/filme";

	@GetMapping(PATH)
	public List<Filme> listar() {
		return filmeService.listar();
	}

	@PostMapping(PATH)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Filme filme) {
		filmeService.salvar(filme);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(PATH + "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Filme filme, @PathVariable long id) {
		filmeService.atualizar(id, filme);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(PATH + "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		filmeService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
