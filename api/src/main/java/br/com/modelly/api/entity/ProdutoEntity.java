package br.com.modelly.api.entity;

import jakarta.persistence.*;

import br.com.modelly.api.dto.ProdutoDTO;

@Entity
@Table(name = "Tb_Produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pk_Id_Produto")
    private Long pkIdProduto;

    @ManyToOne
    @JoinColumn(name = "Fk_id_Loja", nullable = false)
    private LojaEntity loja;

    @Column(name = "Nome_Produto", nullable = false)
    private String nomeProduto;

    @Column(name = "Preco_Produto", nullable = false)
    private float precoProduto;

    @Column(name = "Descricao_Produto", nullable = false, columnDefinition = "TEXT")
    private String descricaoProduto;

    @Column(name = "Categoria_Produto", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProdutoEnum categoriaProduto;

    @Column(name = "Qtd_Produto", nullable = false)
    private int qtdProduto;

    @Column(name = "Pronta_Entrega", nullable = false)
    private boolean prontaEntrega;

    @Column(name = "Tempo_producao", nullable = false)
    private int tempoProducao;

    @Column(name = "Status_Produto", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProdutoEnum statusProduto;

    @Column(name = "Foto_Produto", nullable = true, columnDefinition = "varchar(150) default 'https://drive.google.com/file/d/1bmiUJNi1TAmxyWVlSB423M9X2fuEAWIZ/view?usp=drive_link'")
    private String fotoProduto;

    // Enums
    public enum CategoriaProdutoEnum {
        decoracao, acessorios, velas, moda, pets, infantil, sacolas, casas, madeira, feltro, biscuit, papel
    }

    public enum StatusProdutoEnum {
        producao, disponivel, esgotado
    }

    // CONSTRUTORES
    public ProdutoEntity(ProdutoDTO produtoDTO) {
    	this.pkIdProduto = produtoDTO.getPk_id_produto();
    	this.loja = new LojaEntity(produtoDTO.getLoja());
        this.nomeProduto = produtoDTO.getNome_produto();
        this.precoProduto = produtoDTO.getPreco_produto();
        this.descricaoProduto = produtoDTO.getDescricao_produto();
        this.categoriaProduto = CategoriaProdutoEnum.valueOf(produtoDTO.getCategoria_produto());
        this.qtdProduto = produtoDTO.getQtd_produto();
        this.prontaEntrega = produtoDTO.isPronta_entrega();
        this.tempoProducao = produtoDTO.getTempo_producao();
        this.statusProduto = StatusProdutoEnum.valueOf(produtoDTO.getStatus_produto());
        this.fotoProduto = produtoDTO.getFoto_produto();
    }


    public ProdutoEntity() {
    }

    // GETTER and SETTER
    public Long getPkIdProduto() {
        return pkIdProduto;
    }

    public void setPkIdProduto(Long pkIdProduto) {
        this.pkIdProduto = pkIdProduto;
    }

    public LojaEntity getLoja() {
        return loja;
    }

    public void setLoja(LojaEntity loja) {
        this.loja = loja;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public CategoriaProdutoEnum getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProdutoEnum categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public boolean isProntaEntrega() {
        return prontaEntrega;
    }

    public void setProntaEntrega(boolean prontaEntrega) {
        this.prontaEntrega = prontaEntrega;
    }

    public int getTempoProducao() {
        return tempoProducao;
    }

    public void setTempoProducao(int tempoProducao) {
        this.tempoProducao = tempoProducao;
    }

    public StatusProdutoEnum getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProdutoEnum statusProduto) {
        this.statusProduto = statusProduto;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }
}
