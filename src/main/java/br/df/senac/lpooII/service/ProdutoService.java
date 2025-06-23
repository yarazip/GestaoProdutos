package br.df.senac.lpooII.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.df.senac.lpooII.dto.ProdutoDTO;
import br.df.senac.lpooII.entity.Categoria;
import br.df.senac.lpooII.entity.Produto;
import br.df.senac.lpooII.repository.CategoriaRepository;
import br.df.senac.lpooII.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	public ProdutoDTO salvar(ProdutoDTO dto) {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(dto.getCategoriaId());
		if (!optionalCategoria.isPresent()) {
			return null;
		}
		Categoria categoria = optionalCategoria.get();

		Produto produto = new Produto();
		produto.setNome(dto.getNome());

		produto.setPreco(dto.getPreco());
		produto.setCategoria(categoria);
		Produto salvo = produtoRepository.save(produto);
		ProdutoDTO resposta = new ProdutoDTO(salvo.getId(), salvo.getNome(), salvo.getPreco(),
				salvo.getCategoria().getId());
		return resposta;

	}

	public List<ProdutoDTO> listarTodos() {
		List<Produto> produtos = produtoRepository.findAllOrderById();
		List<ProdutoDTO> dtos = new ArrayList<>();
		for (Produto produto : produtos) {
			dtos.add(new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(),
					produto.getCategoria().getId()));

		}
		return dtos;

	}

	public ProdutoDTO buscarPorId(Long id) {
		Optional<Produto> optionalProd = produtoRepository.findById(id);
		if (optionalProd.isPresent()) {
			Produto aux = optionalProd.get();
			ProdutoDTO dto = new ProdutoDTO(aux.getId(), aux.getNome(), aux.getPreco(), aux.getCategoria().getId());
			return dto;
		}
		return null; // nao existia um produto com o id passado como argumento no método
	}

	public ProdutoDTO atualizar(Long id, ProdutoDTO dtoRecebido) {
		Optional<Produto> optionalProd = produtoRepository.findById(id);
		if (optionalProd.isPresent()) {
			Produto aux = optionalProd.get();
			Optional<Categoria> optionalCategoria = categoriaRepository.findById(dtoRecebido.getCategoriaId());
			if (!optionalCategoria.isPresent()) {
				return null; // caso a categoria nao exista
			}
			aux.setNome(dtoRecebido.getNome());
			aux.setPreco(dtoRecebido.getPreco());
			aux.setCategoria(optionalCategoria.get());
			Produto atualizado = produtoRepository.save(aux);
			ProdutoDTO dto = new ProdutoDTO(atualizado.getId(), atualizado.getNome(), atualizado.getPreco(),
					atualizado.getCategoria().getId());
			return dto;
		}
		return null; // nao existe um produto com o id passado como argumento
	} // fim metodo

	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}
}
