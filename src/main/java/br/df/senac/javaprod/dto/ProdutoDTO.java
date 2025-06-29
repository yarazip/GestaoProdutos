package br.df.senac.javaprod.dto;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {

	private Long id;

	@NotBlank(message = "O nome do produto é obrigatório")

	private String nome;

	@NotNull(message = "O preço é obrigatório")

	@Positive(message = "O preço deve ser maior que zero")

	private BigDecimal preco;

	@NotNull(message = "A categoria do produto é obrigatória")

	private Long categoriaId;

	private String categoriaNome;

// Construtores

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, BigDecimal preco, Long categoriaId, String categoriaNome) {
	    this.id = id;
	    this.nome = nome;
	    this.preco = preco;
	    this.categoriaId = categoriaId;
	    this.categoriaNome = categoriaNome;
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

	public BigDecimal getPreco() {
	    return preco;
	}

	public void setPreco(BigDecimal preco) {
	    this.preco = preco;
	}


	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoriaNome() { 
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) { 
		this.categoriaNome = categoriaNome;
	}

}