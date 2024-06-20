package br.com.modelly.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.modelly.api.service.ProdutoService;
import br.com.modelly.api.dto.ProdutoDTO;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoByID(@PathVariable("id") Long pk_id_produto) {
        return ResponseEntity.ok(produtoService.getProdutoByID(pk_id_produto));
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.listarTudo());
    }
    
    @PostMapping
    public ResponseEntity<Void> createProduto(@RequestBody ProdutoDTO produto) {
        produtoService.createProduto(produto);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable("id") Long pk_id_produto, @RequestBody ProdutoDTO produto) {
        return ResponseEntity.ok(produtoService.updateProduto(pk_id_produto, produto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Long pk_id_produto) {
        produtoService.deleteProduto(pk_id_produto);
        return ResponseEntity.ok().build();
    }
}
