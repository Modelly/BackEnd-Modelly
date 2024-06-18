package br.com.modelly.api.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.modelly.api.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
1- MAPEAMENTO DA CLASSE EM JPA
 - DEFINIR A CLASSE COMO UMA ENTIDADE (TABELA)
 - DEFINIR CADA ATRIBUTO DA ENTIDADE (COLUNAS)
 - DEFINIR AS CARACTERÍSTICAS DE CADA ATRIBUTO (PK, FK, NOT NULL, UNIQUE...)

2- MONTAR OS SETTERS E GETTERS DA CLASSE
 - DEFINIR CADA ATRIBUTO/VAR COMO PRIVADO
 - DEFINIR UM MÉTODO GET PARA ESSE ATRIBUTO
 - DEFINIR UM MÉTODO SET PARA ESSE ATRIBUTO

3- CONFIGURAR O 'APPLICATION.PROPERTIES' PARA RODAR O HIBERNATE
 - DIALETO (MySQL, PostgreSQL, Oracle...)
 - CONFIGURAR A AÇÃO DO HIBERNATE (CRIAR, CRIAR E DROPAR, VALIDAR...)
*/

@Entity // MAPENADO A CLASSE COMO ENTIDADE
@Table(name = "tb_usuario") // DEFININDO COMO DEVE SER O NOME DA ENTIDADE NO BD
public class UsuarioEntity {
	
	@Id // DEFININDO O ATRIBUTO COMO ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pk_id_usuario;
	
	@Column(nullable = false) // DEFININDO O ATRIBUTO COMO NOT NULL
	private String nome_usuario;
	
	@Column(nullable = false, unique = true) // DEFININDO O ATRIBUTO COMO NOT NULL E ÚNICO
	private String cpf_usuario;
	
	@Column(nullable = false)
	private String senha_usuario;
	
	@Column(nullable = false)
	private String email_usuario;
	
	@Column(nullable = false)
	private String genero_usuario;
	
	@Column(nullable = false)
	private String data_nasc_usuario;
	
	@Column(nullable = false)
	private String data_registro_usuario;
	
	@Column(nullable = false)
	private String plano_usuario;
	
	@Column(nullable = false)
	private String permissao_usuario;
	
	@Column(nullable = false)
	private String endereco_usuario;
	
	@Column(nullable = false)
	private String foto_perfil_usuario;
	
	// CONSTRUTOR ENTITY RESPONSÁVEL POR FAZER A CONVERSÃO DOS DTO PARA ENTITY
	public UsuarioEntity(UsuarioDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
	
	// CONSTRUTOR VAZIO
	public UsuarioEntity() {

	}
	
	public Long getPk_id_usuario() {
		return pk_id_usuario;
	}


	public void setPk_id_usuario(Long pk_id_usuario) {
		this.pk_id_usuario = pk_id_usuario;
	}


	public String getNome_usuario() {
		return nome_usuario;
	}


	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}


	public String getCpf_usuario() {
		return cpf_usuario;
	}


	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}


	public String getSenha_usuario() {
		return senha_usuario;
	}


	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}


	public String getEmail_usuario() {
		return email_usuario;
	}


	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}


	public String getGenero_usuario() {
		return genero_usuario;
	}


	public void setGenero_usuario(String genero_usuario) {
		this.genero_usuario = genero_usuario;
	}


	public String getData_nasc_usuario() {
		return data_nasc_usuario;
	}


	public void setData_nasc_usuario(String data_nasc_usuario) {
		this.data_nasc_usuario = data_nasc_usuario;
	}


	public String getData_registro_usuario() {
		return data_registro_usuario;
	}


	public void setData_registro_usuario(String data_registro_usuario) {
		this.data_registro_usuario = data_registro_usuario;
	}


	public String getPlano_usuario() {
		return plano_usuario;
	}


	public void setPlano_usuario(String plano_usuario) {
		this.plano_usuario = plano_usuario;
	}


	public String getPermissao_usuario() {
		return permissao_usuario;
	}


	public void setPermissao_usuario(String permissao_usuario) {
		this.permissao_usuario = permissao_usuario;
	}


	public String getEndereco_usuario() {
		return endereco_usuario;
	}


	public void setEndereco_usuario(String endereco_usuario) {
		this.endereco_usuario = endereco_usuario;
	}


	public String getFoto_usuario() {
		return foto_perfil_usuario;
	}


	public void setFoto_usuario(String foto_perfil_usuario) {
		this.foto_perfil_usuario = foto_perfil_usuario;
	}

	@Override // ANOTAÇÃO JAVA QUE INDICA QUE O MÉTODO REDEFINE UM MÉTODO DA SUPERCLASSE (CLASSE PAI)
	public int hashCode() {
		// ESSE MÉTODO VAI RETORNAR UM CÓDIGO HASH PARA A INSTÂNCIA COM BASE NO ID FORNECIDO (ELA É CHAMADA AUTOMATICAMENTE)
		return Objects.hash(pk_id_usuario); // "Objects" É UMA CLASSE UTILITÁRIA DO PACOTE 'JAVA.UTIL' QUE CONTÉM VÁRIOS MÉTODOS ÚTEIS
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(pk_id_usuario, other.pk_id_usuario);
	}
	
}
