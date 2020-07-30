package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

// TODO Efetue a implementação dos métodos da classe service
public class EstudanteServiceImpl implements EstudandeService {

	EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		
		repository.save(estudante);

	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {

	}

	@Override
	public List<Estudante> buscarEstudantes() {
		
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

}
