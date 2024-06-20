package br.com.modelly.api.entity;

import jakarta.persistence.*;

import br.com.modelly.api.dto.LojaDTO;

@Entity
@Table(name = "Tb_Loja")
public class LojaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pk_Id_Loja")
    private Long pkIdLoja;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Fk_Id_Usuario")
    private UsuarioEntity usuario;

    @Column(name = "Nome_Loja", nullable = false)
    private String nomeLoja;

    @Column(name = "Descricao_Loja", nullable = false)
    private String descricaoLoja;

    @Column(name = "Plano_Loja", nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanoLojaEnum planoLoja;

    @Column(name = "Telefone_Loja", nullable = false)
    private String telefoneLoja;

    @Column(name = "Email_Loja", nullable = false)
    private String emailLoja;

    @Column(name = "CNPJ", nullable = true)
    private String cnpj;

    @Column(name = "Qtd_Colecao", nullable = false)
    private int qtdColecao;

    @Column(name = "Qtd_Produtos", nullable = false)
    private int qtdProdutos;

    @Column(name = "Foto_Perfil_Loja", nullable = true)
    private String fotoPerfilLoja;

    @Column(name = "Banner_Loja", nullable = true)
    private String bannerLoja;

    // Enums
    public enum PlanoLojaEnum {
        papel, pincel, bordado, escultura
    }

    // CONSTRUTORES
    public LojaEntity(LojaDTO lojaDTO) {
        this.pkIdLoja = lojaDTO.getPk_id_loja();
        this.usuario = new UsuarioEntity(lojaDTO.getUsuario());
        this.nomeLoja = lojaDTO.getNome_loja();
        this.descricaoLoja = lojaDTO.getDescricao_loja();
        this.planoLoja = PlanoLojaEnum.valueOf(lojaDTO.getPlano_loja());
        this.telefoneLoja = lojaDTO.getTelefone_loja();
        this.emailLoja = lojaDTO.getEmail_loja();
        this.cnpj = lojaDTO.getCnpj_loja();
        this.qtdColecao = lojaDTO.getQtd_colecao();
        this.qtdProdutos = lojaDTO.getQtd_produtos();
        this.fotoPerfilLoja = lojaDTO.getFoto_perfil_loja();
        this.bannerLoja = lojaDTO.getBanner_loja();
    }

    public LojaEntity() {
    }

    // GETTER and SETTER
    public Long getPkIdLoja() {
        return pkIdLoja;
    }

    public void setPkIdLoja(Long pkIdLoja) {
        this.pkIdLoja = pkIdLoja;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getDescricaoLoja() {
        return descricaoLoja;
    }

    public void setDescricaoLoja(String descricaoLoja) {
        this.descricaoLoja = descricaoLoja;
    }

    public PlanoLojaEnum getPlanoLoja() {
        return planoLoja;
    }

    public void setPlanoLoja(PlanoLojaEnum planoLoja) {
        this.planoLoja = planoLoja;
    }

    public String getTelefoneLoja() {
        return telefoneLoja;
    }

    public void setTelefoneLoja(String telefoneLoja) {
        this.telefoneLoja = telefoneLoja;
    }

    public String getEmailLoja() {
        return emailLoja;
    }

    public void setEmailLoja(String emailLoja) {
        this.emailLoja = emailLoja;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getQtdColecao() {
        return qtdColecao;
    }

    public void setQtdColecao(int qtdColecao) {
        this.qtdColecao = qtdColecao;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public String getFotoPerfilLoja() {
        return fotoPerfilLoja;
    }

    public void setFotoPerfilLoja(String fotoPerfilLoja) {
        this.fotoPerfilLoja = fotoPerfilLoja;
    }

    public String getBannerLoja() {
        return bannerLoja;
    }

    public void setBannerLoja(String bannerLoja) {
        this.bannerLoja = bannerLoja;
    }
}
