package br.com.modelly.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import br.com.modelly.api.dto.ProdutoDTO;
import br.com.modelly.api.entity.ProdutoEntity;
import br.com.modelly.api.repository.ProdutoRepository;
import br.com.modelly.api.repository.LojaRepository;
import br.com.modelly.api.entity.LojaEntity;
import exception.ResourceNotFoundException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private LojaRepository lojaRepository;

    public void createProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoDTO);
        
        // Busca a entidade Loja com base no ID fornecido no DTO
        Optional<LojaEntity> optionalLojaEntity = lojaRepository.findById(produtoDTO.getLoja().getPk_id_loja());
        if (optionalLojaEntity.isEmpty()) {
            throw new ResourceNotFoundException("Loja não encontrada com o ID: " + produtoDTO.getLoja().getPk_id_loja());
        }
        
        // Define a entidade Loja no ProdutoEntity
        produtoEntity.setLoja(optionalLojaEntity.get());
        
        // Salva o ProdutoEntity no banco de dados
        produtoRepository.save(produtoEntity);
    }

    
    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO) {
        // Verifica se o produto existe no banco de dados
        Optional<ProdutoEntity> optionalProdutoEntity = produtoRepository.findById(id);
        if (optionalProdutoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID: " + id);
        }

        // Obtém o ProdutoEntity existente a partir do Optional
        ProdutoEntity produtoExistente = optionalProdutoEntity.get();

        // Atualiza as propriedades do ProdutoEntity com base no ProdutoDTO
        produtoExistente.setNomeProduto(produtoDTO.getNome_produto());
        produtoExistente.setPrecoProduto(produtoDTO.getPreco_produto());
        produtoExistente.setDescricaoProduto(produtoDTO.getDescricao_produto());
        produtoExistente.setCategoriaProduto(ProdutoEntity.CategoriaProdutoEnum.valueOf(produtoDTO.getCategoria_produto()));
        produtoExistente.setQtdProduto(produtoDTO.getQtd_produto());
        produtoExistente.setProntaEntrega(produtoDTO.isPronta_entrega());
        produtoExistente.setTempoProducao(produtoDTO.getTempo_producao());
        produtoExistente.setStatusProduto(ProdutoEntity.StatusProdutoEnum.valueOf(produtoDTO.getStatus_produto()));
        produtoExistente.setFotoProduto(produtoDTO.getFoto_produto());

        // Busca a entidade Loja com base no ID fornecido no DTO
        Optional<LojaEntity> optionalLojaEntity = lojaRepository.findById(produtoDTO.getLoja().getPk_id_loja());
        if (optionalLojaEntity.isEmpty()) {
            throw new ResourceNotFoundException("Loja não encontrada com o ID: " + produtoDTO.getLoja().getPk_id_loja());
        }

        // Define a entidade Loja no ProdutoEntity
        produtoExistente.setLoja(optionalLojaEntity.get());

        // Salva o ProdutoEntity atualizado no banco de dados
        produtoRepository.save(produtoExistente);

        // Retorna o ProdutoDTO atualizado
        return new ProdutoDTO(produtoExistente);
    }


    public ProdutoDTO getProdutoByID(Long pk_id_produto) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(pk_id_produto);
        if (!produto.isPresent()) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID: " + pk_id_produto);
        }
        return new ProdutoDTO(produto.get());
    }

    public List<ProdutoDTO> listarTudo() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }
    
    public void deleteProduto(Long pk_id_produto) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(pk_id_produto);
        if (!produto.isPresent()) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID: " + pk_id_produto);
        }
        produtoRepository.delete(produto.get());
    }
}
