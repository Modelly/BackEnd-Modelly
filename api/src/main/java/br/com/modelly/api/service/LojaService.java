package br.com.modelly.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelly.api.dto.LojaDTO;
import br.com.modelly.api.entity.LojaEntity;
import br.com.modelly.api.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public List<LojaDTO> listarTudo() {
		List<LojaEntity> lojas = lojaRepository.findAll();
		return lojas.stream().map(LojaDTO::new).toList();
	}
	
	public void inserir(LojaDTO loja) {
		LojaEntity lojaEntity = new LojaEntity(loja);
		lojaRepository.save(lojaEntity);
	}
	
	public LojaDTO alterar(LojaDTO loja) {
		LojaEntity lojaEntity = new LojaEntity(loja);
		return new LojaDTO(lojaRepository.save(lojaEntity));
	}
	
	public void excluir(Long pk_id_loja) {
		LojaEntity loja = lojaRepository.findById(pk_id_loja).get();
		lojaRepository.delete(loja);
	}
	
	
}
