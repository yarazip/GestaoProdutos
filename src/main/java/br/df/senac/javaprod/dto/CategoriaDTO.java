 package br.df.senac.javaprod.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

	private Long id;
	
	@NotBlank(message = "Nome é obrigatorio!")
	private String nome;
	
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Long id, String nome) {
		this.id=id;
		this.nome= nome;
	}

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
	
	
}
