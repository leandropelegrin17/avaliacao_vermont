package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import lombok.AllArgsConstructor;

// TODO Efetue a implementação dos métodos da classe service
@Service
@AllArgsConstructor
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	private EstudanteRepository repository;

	@Override
	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		
		@Valid
		Estudante estudanteCadastrado = repository.save(estudante);
		
		return estudanteCadastrado;

	}

	@Override
	public Estudante atualizarEstudante(@Valid Estudante estudante) {

		Estudante estudanteAtualizado = repository.saveAndFlush(estudante);
		
		return estudanteAtualizado;
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		System.out.println("Teste");
		return repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(long id) {
		
		Optional<Estudante> optionalEstudante = repository.findById(id);
		
		if (optionalEstudante.isPresent()) {
			return optionalEstudante.get();
		}
		
		throw new IllegalArgumentException("Identificador inválido:" + id);
	}

	@Override
	public Boolean excluirEstudante(Long id) {
		return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return true;
		           }).orElse(false);
	}

}
