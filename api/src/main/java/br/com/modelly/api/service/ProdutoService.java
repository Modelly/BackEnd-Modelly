package br.com.modelly.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelly.api.dto.ProdutoDTO;
import br.com.modelly.api.entity.ProdutoEntity;
import br.com.modelly.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoDTO> listarTudo() {
		List<ProdutoEntity> produtos = produtoRepository.findAll();
		return produtos.stream().map(ProdutoDTO::new).toList();
	}
	
	public void inserir(ProdutoDTO produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity(produto);
		produtoRepository.save(produtoEntity);
	}
	
	public ProdutoDTO alterar(ProdutoDTO loja) {
		ProdutoEntity produtoEntity = new ProdutoEntity(loja);
		return new ProdutoDTO(produtoRepository.save(produtoEntity));
	}
	
	public void excluir(Long pk_id_produto) {
		ProdutoEntity produto = produtoRepository.findById(pk_id_produto).get();
		produtoRepository.delete(produto);
	}
	
}