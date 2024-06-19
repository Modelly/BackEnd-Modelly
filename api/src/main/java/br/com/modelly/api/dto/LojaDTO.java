package br.com.modelly.api.dto;

import org.springframework.beans.BeanUtils;

import br.com.modelly.api.entity.LojaEntity;


public class LojaDTO {

	private Long Pk_id_Loja;
	private Long Fk_id_Usuario;
	private String Nome_Loja;
	private String Descricao_Loja;
	private String Plano_Loja;
	private String Telefone_Loja;
	private String Email_Loja;
	private String CNPJ_Loja;
	private Long Qtd_Colecao;
	private Long Qtd_Produtos;
	private String Foto_Perfil_Loja;
	private String Banner_Loja;
	
	// CONSTRUTOR ENTITY RESPONSÁVEL POR FAZER A CONVERSÃO DOS DTO PARA ENTITY
	public LojaDTO(LojaEntity loja) {
		BeanUtils.copyProperties(loja, this);
	}
	
	// CONSTRUTOR VAZIO
	public LojaDTO() {

	}
	
	//GETTER and SETTER
	public Long getPk_id_Loja() {
		return Pk_id_Loja;
	}

	public void setPk_id_Loja(Long pk_id_Loja) {
		Pk_id_Loja = pk_id_Loja;
	}

	public Long getFk_id_Usuario() {
		return Fk_id_Usuario;
	}

	public void setFk_id_Usuario(Long fk_id_Usuario) {
		Fk_id_Usuario = fk_id_Usuario;
	}

	public String getNome_Loja() {
		return Nome_Loja;
	}

	public void setNome_Loja(String nome_Loja) {
		Nome_Loja = nome_Loja;
	}

	public String getDescricao_Loja() {
		return Descricao_Loja;
	}

	public void setDescricao_Loja(String descricao_Loja) {
		Descricao_Loja = descricao_Loja;
	}

	public String getPlano_Loja() {
		return Plano_Loja;
	}

	public void setPlano_Loja(String plano_Loja) {
		Plano_Loja = plano_Loja;
	}

	public String getTelefone_Loja() {
		return Telefone_Loja;
	}

	public void setTelefone_Loja(String telefone_Loja) {
		Telefone_Loja = telefone_Loja;
	}

	public String getEmail_Loja() {
		return Email_Loja;
	}

	public void setEmail_Loja(String email_Loja) {
		Email_Loja = email_Loja;
	}

	public String getCNPJ_Loja() {
		return CNPJ_Loja;
	}

	public void setCNPJ_Loja(String cNPJ_Loja) {
		CNPJ_Loja = cNPJ_Loja;
	}

	public Long getQtd_Colecao() {
		return Qtd_Colecao;
	}

	public void setQtd_Colecao(Long qtd_Colecao) {
		Qtd_Colecao = qtd_Colecao;
	}

	public Long getQtd_Produtos() {
		return Qtd_Produtos;
	}

	public void setQtd_Produtos(Long qtd_Produtos) {
		Qtd_Produtos = qtd_Produtos;
	}

	public String getFoto_Perfil_Loja() {
		return Foto_Perfil_Loja;
	}

	public void setFoto_Perfil_Loja(String foto_Perfil_Loja) {
		Foto_Perfil_Loja = foto_Perfil_Loja;
	}

	public String getBanner_Loja() {
		return Banner_Loja;
	}

	public void setBanner_Loja(String banner_Loja) {
		Banner_Loja = banner_Loja;
	}
}
