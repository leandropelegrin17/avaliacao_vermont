package br.com.tokiomarine.seguradora.avaliacao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ESTUDANTE")
@Getter
@Setter
public class Estudante implements Serializable {
	
	private static final long serialVersionUID = 3417953434619760983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome é Obrigatório")
	@Column(name = "NOME")
	private String nome;
	
	@NotNull(message = "Email é Obrigatório")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@NotNull(message = "Matricula é Obrigatório")
	@Column(name = "MATRICULA")
	private String matricula;
	
	@Column(name = "CURSO")
	private String curso;

}
