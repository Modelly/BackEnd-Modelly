package br.com.modelly.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelly.api.dto.UsuarioDTO;
import br.com.modelly.api.entity.UsuarioEntity;
import br.com.modelly.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository; // criando uma var do tipo usuario repotsitory para ter acesso ao bd e os métodos contidos dentro dele
	
	public List<UsuarioDTO> listarTudo() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll(); // puxando todos os usuarios do bd e armazenanado numa lista de usuarios dto
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario); // convertendo DTO -> Repository
		usuarioRepository.save(usuarioEntity); // salvando usuario no banco de dados
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario); // convertendo DTO -> Repository
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity)); // salvando usuario no banco de dados e retornando o usuario convertendo ele para dto
	}
	
	public void excluir(Long pk_id_usuario) {
		UsuarioEntity usuario = usuarioRepository.findById(pk_id_usuario).get();
		usuarioRepository.delete(usuario);
	}

}
