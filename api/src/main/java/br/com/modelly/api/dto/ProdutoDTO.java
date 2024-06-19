package br.com.modelly.api.dto;

import org.springframework.beans.BeanUtils;

import br.com.modelly.api.entity.ProdutoEntity;

public class ProdutoDTO {
	
	private Long pk_id_produto;
	private Long fk_id_loja;
	private String nome_produto;
	private float preco_produto;
	private String descricao_produto;
	private String categoria_produto;
	private Long qtd_produto;
	private boolean pronta_entrega;
	private Long tempo_producao;
	private String status_produto;
	private String foto_produto;
	
	// CONSTRUTORES
	public ProdutoDTO(ProdutoEntity produto) {
		BeanUtils.copyProperties(produto, this);
	}
	
	// CONSTRUTOR VAZIO
	public ProdutoDTO() {

	}
	
	// GETTER and SETTER
	public Long getPk_id_produto() {
		return pk_id_produto;
	}
	public void setPk_id_produto(Long pk_id_produto) {
		this.pk_id_produto = pk_id_produto;
	}
	public Long getFk_id_loja() {
		return fk_id_loja;
	}
	public void setFk_id_loja(Long fk_id_loja) {
		this.fk_id_loja = fk_id_loja;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public float getPreco_produto() {
		return preco_produto;
	}
	public void setPreco_produto(float preco_produto) {
		this.preco_produto = preco_produto;
	}
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public String getCategoria_produto() {
		return categoria_produto;
	}
	public void setCategoria_produto(String categoria_produto) {
		this.categoria_produto = categoria_produto;
	}
	public Long getQtd_produto() {
		return qtd_produto;
	}
	public void setQtd_produto(Long qtd_produto) {
		this.qtd_produto = qtd_produto;
	}
	public boolean isPronta_entrega() {
		return pronta_entrega;
	}
	public void setPronta_entrega(boolean pronta_entrega) {
		this.pronta_entrega = pronta_entrega;
	}
	public Long getTempo_producao() {
		return tempo_producao;
	}
	public void setTempo_producao(Long tempo_producao) {
		this.tempo_producao = tempo_producao;
	}
	public String getStatus_produto() {
		return status_produto;
	}
	public void setStatus_produto(String status_produto) {
		this.status_produto = status_produto;
	}
	public String getFoto_produto() {
		return foto_produto;
	}
	public void setFoto_produto(String foto_produto) {
		this.foto_produto = foto_produto;
	}
	
}
