package br.com.modelly.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.modelly.api.entity.ProdutoEntity;

// INTERFACE JAVA QUE ESTÁ HERDANDO MÉTODOS DO JPAREPOSITORY (MÉTODOS DE CRUD)
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{
	// METODOS DE CONSULTA
}
