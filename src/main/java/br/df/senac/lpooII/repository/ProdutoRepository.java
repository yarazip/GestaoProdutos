package br.df.senac.lpooII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.df.senac.lpooII.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
