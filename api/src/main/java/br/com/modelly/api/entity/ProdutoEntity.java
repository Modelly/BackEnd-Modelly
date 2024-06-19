package br.com.modelly.api.entity;

import org.springframework.beans.BeanUtils;

import br.com.modelly.api.dto.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pk_id_produto;
	
	@Column(nullable = false)
	private Long fk_id_loja;
	
	@Column(nullable = false)
	private String nome_produto;
	
	@Column(nullable = false)
	private float preco_produto;
	
	@Column(nullable = false)
	private String descricao_produto;
	
	@Column(nullable = false)
	private String categoria_produto;
	
	@Column(nullable = false)
	private Long qtd_produto;
	
	@Column(nullable = false)
	private boolean pronta_entrega;
	
	@Column(nullable = false)
	private Long tempo_producao;
	
	@Column(nullable = false)
	private String status_produto;
	
	@Column(nullable = false)
	private String foto_produto;
	
	// CONSTRUTORES
	public ProdutoEntity(ProdutoDTO produto) {
		BeanUtils.copyProperties(produto, this);
	}
	
	public ProdutoEntity() {
		
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