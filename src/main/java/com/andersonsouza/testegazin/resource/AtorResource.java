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

import com.andersonsouza.testegazin.domain.entity.Ator;
import com.andersonsouza.testegazin.services.AtorService;

@RestController
public class AtorResource {

	@Autowired
	AtorService atorService;

	private static final String PATH = "/ator";

	@GetMapping(PATH)
	public List<Ator> listar() {
		return atorService.listar();
	}

	@PostMapping(PATH)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Ator ator) {
		atorService.salvar(ator);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ator.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(PATH + "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Ator ator, @PathVariable long id) {
		atorService.atualizar(id, ator);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(PATH + "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		atorService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
