package br.com.modelly.api.dto;


import br.com.modelly.api.entity.LojaEntity;

public class LojaDTO {

    private Long pk_id_loja;
    private UsuarioDTO usuario;
    private String nome_loja;
    private String descricao_loja;
    private String plano_loja;
    private String telefone_loja;
    private String email_loja;
    private String cnpj_loja;
    private Integer qtd_colecao;
    private Integer qtd_produtos;
    private String foto_perfil_loja;
    private String banner_loja;

    public LojaDTO(LojaEntity lojaEntity) {
        this.pk_id_loja = lojaEntity.getPkIdLoja();
        this.usuario = new UsuarioDTO(lojaEntity.getUsuario());
        this.nome_loja = lojaEntity.getNomeLoja();
        this.descricao_loja = lojaEntity.getDescricaoLoja();
        this.plano_loja = lojaEntity.getPlanoLoja().name();
        this.telefone_loja = lojaEntity.getTelefoneLoja();
        this.email_loja = lojaEntity.getEmailLoja();
        this.cnpj_loja = lojaEntity.getCnpj();
        this.qtd_colecao = lojaEntity.getQtdColecao();
        this.qtd_produtos = lojaEntity.getQtdProdutos();
        this.foto_perfil_loja = lojaEntity.getFotoPerfilLoja();
        this.banner_loja = lojaEntity.getBannerLoja();
    }

    public LojaDTO() {
    }

    public Long getPk_id_loja() {
        return pk_id_loja;
    }

    public void setPk_id_loja(Long pk_id_loja) {
        this.pk_id_loja = pk_id_loja;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getNome_loja() {
        return nome_loja;
    }

    public void setNome_loja(String nome_loja) {
        this.nome_loja = nome_loja;
    }

    public String getDescricao_loja() {
        return descricao_loja;
    }

    public void setDescricao_loja(String descricao_loja) {
        this.descricao_loja = descricao_loja;
    }

    public String getPlano_loja() {
        return plano_loja;
    }

    public void setPlano_loja(String plano_loja) {
        this.plano_loja = plano_loja;
    }

    public String getTelefone_loja() {
        return telefone_loja;
    }

    public void setTelefone_loja(String telefone_loja) {
        this.telefone_loja = telefone_loja;
    }

    public String getEmail_loja() {
        return email_loja;
    }

    public void setEmail_loja(String email_loja) {
        this.email_loja = email_loja;
    }

    public String getCnpj_loja() {
        return cnpj_loja;
    }

    public void setCnpj_loja(String cnpj_loja) {
        this.cnpj_loja = cnpj_loja;
    }

    public Integer getQtd_colecao() {
        return qtd_colecao;
    }

    public void setQtd_colecao(Integer qtd_colecao) {
        this.qtd_colecao = qtd_colecao;
    }

    public Integer getQtd_produtos() {
        return qtd_produtos;
    }

    public void setQtd_produtos(Integer qtd_produtos) {
        this.qtd_produtos = qtd_produtos;
    }

    public String getFoto_perfil_loja() {
        return foto_perfil_loja;
    }

    public void setFoto_perfil_loja(String foto_perfil_loja) {
        this.foto_perfil_loja = foto_perfil_loja;
    }

    public String getBanner_loja() {
        return banner_loja;
    }

    public void setBanner_loja(String banner_loja) {
        this.banner_loja = banner_loja;
    }
}
