package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	// TODO efetue a correção dos problemas que existem na classe Estudante Controller
	EstudandeService service;

	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public String listarEstudantes(Model model) {
		System.out.println("Passei aqui");
		model.addAttribute("estudtes", service.buscarEstudantes());
		return "index";
	}

	@PostMapping("add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		System.out.println("adicionarEstudante");
		if (result.hasErrors()) {
			return "cadastrar-estudante";
		}

		service.cadastrarEstudante(estudante);

		return "redirect:listar";
	}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(long id, Model model) {
		Estudante estudante = service.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	@PutMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// estudante.setId(id);
			return "atualizar-estudante";
		}

		service.atualizarEstudante(estudante);

		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}

	@DeleteMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") long id, Model model) {
		// TODO IMPLEMENTAR A EXCLUSAO DE ESTUDANTES
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}
}
