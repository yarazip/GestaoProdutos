package br.df.senac.lpooII.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.df.senac.lpooII.dto.ProdutoDTO;
import br.df.senac.lpooII.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<ProdutoDTO> criar(@RequestBody @Valid ProdutoDTO dto) {

		ProdutoDTO novoProduto = produtoService.salvar(dto);
		if (novoProduto != null) {
			return ResponseEntity.ok(novoProduto);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarTodos() {
		List<ProdutoDTO> produtos = produtoService.listarTodos();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) {
		ProdutoDTO dto = produtoService.buscarPorId(id);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> atualizarPorId(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dtoNovo) {
		ProdutoDTO dto = produtoService.atualizar(id, dtoNovo);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
