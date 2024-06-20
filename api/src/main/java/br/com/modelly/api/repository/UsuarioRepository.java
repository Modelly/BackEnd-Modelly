package br.com.modelly.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.modelly.api.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}