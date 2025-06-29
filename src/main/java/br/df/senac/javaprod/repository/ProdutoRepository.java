package br.df.senac.javaprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.df.senac.javaprod.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT p FROM Produto p ORDER BY p.id")
	public List<Produto> findAllOrderById();

	@Query("SELECT p FROM Produto p ORDER BY p.nome")
	public List<Produto> findAllOrderByNome();
}
