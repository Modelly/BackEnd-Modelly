package br.com.modelly.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelly.api.dto.UsuarioDTO;
import br.com.modelly.api.entity.UsuarioEntity;
import br.com.modelly.api.repository.UsuarioRepository;
import exception.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTudo() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.validarCamposNotNull();
        UsuarioEntity savedEntity = usuarioRepository.save(usuarioEntity);
        return new UsuarioDTO(savedEntity);
    }

    public UsuarioDTO alterar(Long id, UsuarioDTO usuario) {
        Optional<UsuarioEntity> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        UsuarioEntity usuarioEntity = existingUsuario.get();
        usuarioEntity.setNomeUsuario(usuario.getNome_usuario());
        usuarioEntity.setCpfUsuario(usuario.getCpf_usuario());
        usuarioEntity.setEmailUsuario(usuario.getEmail_usuario());
        usuarioEntity.setGeneroUsuario(UsuarioEntity.GeneroUsuarioEnum.valueOf(usuario.getGenero_usuario().toLowerCase()));
        usuarioEntity.setDataNascUsuario(usuario.getData_nasc_usuario());
        usuarioEntity.setDataRegistroUsuario(usuario.getData_registro_usuario());
        usuarioEntity.setPlanoUsuario(UsuarioEntity.PlanoUsuarioEnum.valueOf(usuario.getPlano_usuario().toLowerCase()));
        usuarioEntity.setPermissaoUsuario(UsuarioEntity.PermissaoUsuarioEnum.valueOf(usuario.getPermissao_usuario().toLowerCase()));
        usuarioEntity.setEnderecoUsuario(usuario.getEndereco_usuario());
        usuarioEntity.setFotoPerfilUsuario(usuario.getFoto_perfil_usuario());
        usuarioEntity.setSenhaUsuario(usuario.getSenha_usuario());
        usuarioEntity.validarCamposNotNull();
        UsuarioEntity updatedEntity = usuarioRepository.save(usuarioEntity);
        return new UsuarioDTO(updatedEntity);
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO findById(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        return new UsuarioDTO(usuarioEntity);
    }
}
