package br.df.senac.javaprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.df.senac.javaprod.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("SELECT c FROM Categoria c ORDER BY c.nome")
	public List<Categoria> findAllOrderByNome();
	
	@Query("SELECT c FROM Categoria c ORDER BY c.id")
	public List<Categoria> findAllOrderById();
}
