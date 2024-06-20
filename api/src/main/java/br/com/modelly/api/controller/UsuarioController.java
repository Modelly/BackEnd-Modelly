package br.com.modelly.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.modelly.api.dto.UsuarioDTO;
import br.com.modelly.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTudo() {
        return usuarioService.listarTudo();
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.inserir(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> alterar(@PathVariable Long id, @RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuarioAtualizado = usuarioService.alterar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }
}
