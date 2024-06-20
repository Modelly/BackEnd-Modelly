package br.com.modelly.api.dto;

import br.com.modelly.api.entity.UsuarioEntity;

import java.sql.Date;

public class UsuarioDTO {

    private Long pk_id_usuario;
    private String nome_usuario;
    private String cpf_usuario;
    private String senha_usuario;
    private String email_usuario;
    private String genero_usuario;
    private Date data_nasc_usuario;
    private Date data_registro_usuario;
    private String plano_usuario;
    private String permissao_usuario;
    private String endereco_usuario;
    private String foto_perfil_usuario;

    public UsuarioDTO(UsuarioEntity usuario) {
        this.pk_id_usuario = usuario.getPkIdUsuario();
        this.nome_usuario = usuario.getNomeUsuario();
        this.cpf_usuario = usuario.getCpfUsuario();
        this.genero_usuario = usuario.getGeneroUsuario().name();
        this.data_nasc_usuario = usuario.getDataNascUsuario();
        this.data_registro_usuario = usuario.getDataRegistroUsuario();
        this.plano_usuario = usuario.getPlanoUsuario().name();
        this.permissao_usuario = usuario.getPermissaoUsuario().name();
        this.email_usuario = usuario.getEmailUsuario();
        this.endereco_usuario = usuario.getEnderecoUsuario();
        this.foto_perfil_usuario = usuario.getFotoPerfilUsuario();
        this.senha_usuario = usuario.getSenhaUsuario();
    }

    public UsuarioDTO() {
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

    public Date getData_nasc_usuario() {
        return data_nasc_usuario;
    }

    public void setData_nasc_usuario(Date data_nasc_usuario) {
        this.data_nasc_usuario = data_nasc_usuario;
    }

    public Date getData_registro_usuario() {
        return data_registro_usuario;
    }

    public void setData_registro_usuario(Date data_registro_usuario) {
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

    public String getFoto_perfil_usuario() {
        return foto_perfil_usuario;
    }

    public void setFoto_perfil_usuario(String foto_perfil_usuario) {
        this.foto_perfil_usuario = foto_perfil_usuario;
    }
}
