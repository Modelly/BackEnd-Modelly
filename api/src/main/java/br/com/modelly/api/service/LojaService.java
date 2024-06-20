package br.com.modelly.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelly.api.dto.LojaDTO;
import br.com.modelly.api.entity.LojaEntity;
import br.com.modelly.api.entity.UsuarioEntity;
import br.com.modelly.api.repository.LojaRepository;
import br.com.modelly.api.repository.UsuarioRepository;
import exception.ResourceNotFoundException;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<LojaDTO> getAll() {
        List<LojaEntity> lojas = lojaRepository.findAll();
        return lojas.stream().map(LojaDTO::new).toList();
    }

    public LojaDTO getLojaByID(Long pk_id_loja) {
        Optional<LojaEntity> loja = lojaRepository.findById(pk_id_loja);
        if (loja.isEmpty()) {
            throw new ResourceNotFoundException("Loja não encontrada com o ID: " + pk_id_loja);
        }
        return new LojaDTO(loja.get());
    }

    public LojaDTO createLoja(LojaDTO lojaDTO, Long id) {
    	 UsuarioEntity usuario = usuarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
    	
        LojaEntity novaLoja = new LojaEntity(lojaDTO);
        novaLoja.setUsuario(usuario);
        LojaEntity savedEntity = lojaRepository.save(novaLoja);
        return new LojaDTO(savedEntity);
    }

    // Não está funcionando devidamente
    public LojaDTO updateLoja(Long id, LojaDTO lojaDTO) {
        Optional<LojaEntity> optionalLoja = lojaRepository.findById(id);
        if (optionalLoja.isEmpty()) {
            throw new ResourceNotFoundException("Loja não encontrada com o ID: " + id);
        }

        LojaEntity lojaExistente = optionalLoja.get();
        BeanUtils.copyProperties(lojaDTO, lojaExistente, "pk_id_loja", "usuario");

        lojaRepository.save(lojaExistente);

        return new LojaDTO(lojaExistente);
    }

    public void excluir(Long pk_id_loja) {
        LojaEntity loja = lojaRepository.findById(pk_id_loja)
                .orElseThrow(() -> new ResourceNotFoundException("Loja não encontrada com o ID: " + pk_id_loja));

        lojaRepository.delete(loja);
    }
}
