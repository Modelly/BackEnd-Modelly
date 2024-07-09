package br.com.modelly.api.entity;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Objects;

import br.com.modelly.api.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity
@Table(name = "Tb_Usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pk_id_Usuario")
    private Long pkIdUsuario;

    @Column(name = "Nome_Usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "CPF_Usuario", nullable = false, unique = true)
    private String cpfUsuario;

    @Column(name = "Genero_Usuario", nullable = true)
    @Enumerated(EnumType.STRING)
    private GeneroUsuarioEnum generoUsuario;

    @Column(name = "Data_Nasc_Usuario", nullable = true)
    private Date dataNascUsuario;

    @Column(name = "Data_Registro_Usuario", nullable = false)
    private Date dataRegistroUsuario;

    @Column(name = "Plano_Usuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanoUsuarioEnum planoUsuario;

    @Column(name = "Permissao_Usuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissaoUsuarioEnum permissaoUsuario;

    @Column(name = "Email_Usuario", nullable = false)
    private String emailUsuario;

    @Column(name = "Endereco_Usuario", nullable = true)
    private String enderecoUsuario;

    @Column(name = "Foto_Perfil_Usuario", nullable = true)
    private String fotoPerfilUsuario;

    @Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;

    // Enums
    public enum GeneroUsuarioEnum {
        masculino, feminino, outro
    }

    public enum PlanoUsuarioEnum {
        admirador, entusiasta, colecionador
    }

    public enum PermissaoUsuarioEnum {
        consumidor, artesao
    }

    // CONSTRUTORES
    public UsuarioEntity(UsuarioDTO usuario) {
        this.nomeUsuario = usuario.getNome_usuario();
        this.cpfUsuario = usuario.getCpf_usuario();
        this.generoUsuario = GeneroUsuarioEnum.valueOf(usuario.getGenero_usuario());
        this.dataNascUsuario = usuario.getData_nasc_usuario();
        this.dataRegistroUsuario = usuario.getData_registro_usuario();
        this.planoUsuario = PlanoUsuarioEnum.valueOf(usuario.getPlano_usuario());
        this.permissaoUsuario = PermissaoUsuarioEnum.valueOf(usuario.getPermissao_usuario());
        this.emailUsuario = usuario.getEmail_usuario();
        this.enderecoUsuario = usuario.getEndereco_usuario();
        this.fotoPerfilUsuario = usuario.getFoto_perfil_usuario();
        this.senhaUsuario = usuario.getSenha_usuario();
    }

    public UsuarioEntity() {
    }
    
    public void validarCamposNotNull() {
        Field[] campos = this.getClass().getDeclaredFields();
        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Column.class)) {
                Column coluna = campo.getAnnotation(Column.class);
                if (!coluna.nullable()) {
                    try {
                        campo.setAccessible(true);
                        Object valorCampo = campo.get(this);
                        if (valorCampo == null) {
                            throw new IllegalArgumentException("Campo obrigatório está nulo: " + campo.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace(); // ou lance uma exceção apropriada
                    }
                }
            }
        }
    }

    // GETTER and SETTER
    public Long getPkIdUsuario() {
        return pkIdUsuario;
    }

    public void setPkIdUsuario(Long pkIdUsuario) {
        this.pkIdUsuario = pkIdUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public GeneroUsuarioEnum getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(GeneroUsuarioEnum generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public Date getDataNascUsuario() {
        return dataNascUsuario;
    }

    public void setDataNascUsuario(Date dataNascUsuario) {
        this.dataNascUsuario = dataNascUsuario;
    }

    public Date getDataRegistroUsuario() {
        return dataRegistroUsuario;
    }

    public void setDataRegistroUsuario(Date dataRegistroUsuario) {
        this.dataRegistroUsuario = dataRegistroUsuario;
    }

    public PlanoUsuarioEnum getPlanoUsuario() {
        return planoUsuario;
    }

    public void setPlanoUsuario(PlanoUsuarioEnum planoUsuario) {
        this.planoUsuario = planoUsuario;
    }

    public PermissaoUsuarioEnum getPermissaoUsuario() {
        return permissaoUsuario;
    }

    public void setPermissaoUsuario(PermissaoUsuarioEnum permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getFotoPerfilUsuario() {
        return fotoPerfilUsuario;
    }

    public void setFotoPerfilUsuario(String fotoPerfilUsuario) {
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }


	@Override // ANOTAÇÃO JAVA QUE INDICA QUE O MÉTODO REDEFINE UM MÉTODO DA SUPERCLASSE (CLASSE PAI)
	public int hashCode() {
		// ESSE MÉTODO VAI RETORNAR UM CÓDIGO HASH PARA A INSTÂNCIA COM BASE NO ID FORNECIDO (ELA É CHAMADA AUTOMATICAMENTE)
		return Objects.hash(pkIdUsuario); // "Objects" É UMA CLASSE UTILITÁRIA DO PACOTE 'JAVA.UTIL' QUE CONTÉM VÁRIOS MÉTODOS ÚTEIS
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
		return Objects.equals(pkIdUsuario, other.pkIdUsuario);
	}
	
}
