package br.com.modelly.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.modelly.api.service.LojaService;
import br.com.modelly.api.dto.LojaDTO;

@RestController
@RequestMapping(value = "/loja")
public class LojaController {

	@Autowired
	private LojaService lojaService;
	
	@GetMapping
	public List<LojaDTO> listarTodos() {
		return lojaService.listarTudo();
	}
	
	@PostMapping
	public void inserir(@RequestBody LojaDTO loja) {
		lojaService.inserir(loja);
	}
	
	@PutMapping
	public LojaDTO alterar(@RequestBody LojaDTO loja) {
		return lojaService.alterar(loja);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long pk_id_loja) {
		lojaService.excluir(pk_id_loja);
		return ResponseEntity.ok().build();
	}
}
