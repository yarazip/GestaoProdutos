
package br.df.senac.lpooII.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {

	private Long id;

	@NotBlank(message = "O nome do produto é obrigatório")

	private String nome;

	@NotNull(message = "O preço é obrigatório")

	@Positive(message = "O preço deve ser maior que zero")

	private Double preco;

	@NotNull(message = "A categoria do produto é obrigatória")

	private Long categoriaId;

// Construtores

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, Double preco, Long categoriaId) {

		this.id = id;

		this.nome = nome;

		this.preco = preco;

		this.categoriaId = categoriaId;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

// implemente Getters e Setters de cada atributo

}