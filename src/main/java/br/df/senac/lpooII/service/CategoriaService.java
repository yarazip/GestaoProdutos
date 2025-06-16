package br.df.senac.lpooII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.df.senac.lpooII.dto.CategoriaDTO;
import br.df.senac.lpooII.entity.Categoria;
import br.df.senac.lpooII.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public CategoriaDTO salvar(CategoriaDTO newCategoria) {
		Categoria categoria = new Categoria();
		categoria.setNome(newCategoria.getNome());
		Categoria salvar = categoriaRepository.save(categoria);
		CategoriaDTO resposta= new CategoriaDTO();
		resposta.setNome(salvar.getNome());
		resposta.setId(salvar.getId());
		return resposta;
	}//fim metodo
	
	public List<CategoriaDTO> ListarTodas(){
		
		List<Categoria> allCategoria= categoriaRepository.findAllOrderByNome();
		List<CategoriaDTO> resposta = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : allCategoria) {
			resposta.add(new CategoriaDTO(categoria.getId(), categoria.getNome()));
		}
		return resposta;
	}//fim metodo

	public CategoriaDTO buscarPorId(Long id) {
		Optional<Categoria> categoriaId= categoriaRepository.findById(id);
		if(categoriaId.isPresent()) {
			return new CategoriaDTO(categoriaId.get().getId(), categoriaId.get().getNome());
		}
		return null;
	}//fim metodo
	public CategoriaDTO atualizar(Long id, CategoriaDTO dtoReceive) {
		Optional<Categoria> categoriaId= categoriaRepository.findById(id);
		if(categoriaId.isPresent()) {
		 Categoria nova = new Categoria();
		 nova.setId(categoriaId.get().getId());
		 nova.setNome(dtoReceive.getNome());
		 categoriaRepository.save(nova);
		 return this.buscarPorId(id);
		}//fim if
		return null;
	}//fim metodo
	public void deletar(Long id) {
		categoriaRepository.deleteById(id);
	}
}//fim class
