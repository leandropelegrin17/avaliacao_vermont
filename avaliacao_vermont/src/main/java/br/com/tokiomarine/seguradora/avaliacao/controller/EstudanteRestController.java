package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

// TODO não esquecer de usar as anotações para criação do restcontroller
@RestController
@RequestMapping("/estudante")
public class EstudanteRestController {
	
	@Autowired
	private EstudanteRepository repository;

	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em forma de RESTCONTROLLER (seguindo o padrão RESTFUL)

	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)
	@PostMapping
	public ResponseEntity<Estudante> adicionarEstudante(@Valid @RequestBody() Estudante estudante) {
		
		Estudante estudanteSalvo = repository.save(estudante);
		return new ResponseEntity<>(estudanteSalvo, HttpStatus.OK);
	}

	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)
	@PutMapping
	public ResponseEntity<Estudante> atualizarEstudante(@Valid @RequestBody() Estudante estudante) {
		
		Estudante estudanteSalvo = repository.saveAndFlush(estudante);
		return new ResponseEntity<>(estudanteSalvo, HttpStatus.OK);
	}

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)
	@GetMapping
	public ResponseEntity<List<Estudante>> listarTodos() {
		EstudanteServiceImpl service = new EstudanteServiceImpl();
		
		List<Estudante> estudantes = repository.findAll();
		return new ResponseEntity<>(estudantes, HttpStatus.OK);
	}

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> excluirEstudante(@PathVariable Long id) {
		return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
}
