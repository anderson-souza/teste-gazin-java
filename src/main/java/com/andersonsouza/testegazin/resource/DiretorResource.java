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

import com.andersonsouza.testegazin.domain.entity.Diretor;
import com.andersonsouza.testegazin.services.DiretorService;

@RestController
public class DiretorResource {

	@Autowired
	DiretorService diretorService;

	private static final String PATH = "/diretor";

	@GetMapping(PATH)
	public List<Diretor> listar() {
		return diretorService.listar();
	}

	@PostMapping(PATH)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Diretor diretor) {
		diretorService.salvar(diretor);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(diretor.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(PATH + "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Diretor diretor, @PathVariable long id) {
		diretorService.atualizar(id, diretor);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(PATH + "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		diretorService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
