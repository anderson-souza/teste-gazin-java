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

import com.andersonsouza.testegazin.domain.entity.Produtor;
import com.andersonsouza.testegazin.services.ProdutorService;

@RestController
public class ProdutorResource {

	@Autowired
	ProdutorService produtorService;

	private static final String PATH = "/produtor";

	@GetMapping(PATH)
	public List<Produtor> listar() {
		return produtorService.listar();
	}

	@PostMapping(PATH)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Produtor produtor) {
		produtorService.salvar(produtor);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtor.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(PATH + "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Produtor produtor, @PathVariable long id) {
		produtorService.atualizar(id, produtor);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(PATH + "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		produtorService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
