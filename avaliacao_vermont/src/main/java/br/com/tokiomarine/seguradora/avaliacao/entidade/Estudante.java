package br.com.tokiomarine.seguradora.avaliacao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "ESTUDANTE")
public class Estudante implements Serializable {
	
	private static final long serialVersionUID = 3417953434619760983L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Nome é Obrigatório")
	@Column(name = "NOME")
	private String nome;
	
	@NotNull(message = "Email é Obrigatório")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFON")
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
