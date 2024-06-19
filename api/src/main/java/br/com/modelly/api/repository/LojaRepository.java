package br.com.modelly.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.modelly.api.entity.LojaEntity;

// INTERFACE JAVA QUE ESTÁ HERDANDO MÉTODOS DO JPAREPOSITORY (MÉTODOS DE CRUD)
public interface LojaRepository extends JpaRepository<LojaEntity, Long>{
	// METODOS DE CONSULTA
}
