package br.com.modelly.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.modelly.api.entity.UsuarioEntity;

// INTERFACE JAVA QUE ESTÁ HERDANDO MÉTODOS DO JPAREPOSITORY (MÉTODOS DE CRUD)
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	// METODOS DE CONSULTA
}
