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

import br.df.senac.lpooII.dto.CategoriaDTO;
import br.df.senac.lpooII.service.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> salvar (@RequestBody @Valid CategoriaDTO catDTO){
		CategoriaDTO nova= categoriaService.salvar(catDTO);
		return ResponseEntity.ok(nova);
	}//fim do metodo
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listarTodas(){
		List<CategoriaDTO> resposta= categoriaService.ListarTodas();
		return ResponseEntity.ok(resposta);
	}//fim do metodo
	
	@GetMapping("{id}")
	public ResponseEntity<CategoriaDTO> listarPorId(@PathVariable("id") Long id){
		CategoriaDTO resposta= categoriaService.buscarPorId(id);
			if (resposta !=null){
				return ResponseEntity.ok(resposta);//200
			}
			else {
				return ResponseEntity.notFound().build();//404
			}
	}//fim do metodo
	
	@PutMapping("{id}")
	public ResponseEntity<CategoriaDTO> atualizar(@PathVariable("id") Long id, 
												  @RequestBody @Valid CategoriaDTO catDTO){
		CategoriaDTO resposta= categoriaService.atualizar(id, catDTO);
			if (resposta !=null){
				return ResponseEntity.ok(resposta);//200
			}
			else {
				return ResponseEntity.notFound().build();//404
			}
	}//fim do metodo
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.deletar(id);
		return ResponseEntity.noContent().build();
	}//fim do metodo
	
}//fim class
