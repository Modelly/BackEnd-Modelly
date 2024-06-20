package br.com.modelly.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.modelly.api.service.LojaService;
import br.com.modelly.api.dto.LojaDTO;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public List<LojaDTO> listarTodasLojas() {
        return lojaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LojaDTO> getLojaByID(@PathVariable Long id) {
        return ResponseEntity.ok(lojaService.getLojaByID(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> inserirLoja(@PathVariable Long id, @RequestBody LojaDTO lojaDTO) {
        lojaService.createLoja(lojaDTO, id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LojaDTO> alterarLoja(@PathVariable Long id, @RequestBody LojaDTO lojaDTO) {
        LojaDTO lojaAlterada = lojaService.updateLoja(id, lojaDTO);
        return ResponseEntity.ok(lojaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLoja(@PathVariable Long id) {
        lojaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
