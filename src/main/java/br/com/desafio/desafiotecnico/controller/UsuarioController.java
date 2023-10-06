package br.com.desafio.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.desafio.desafiotecnico.model.Usuario;
import br.com.desafio.desafiotecnico.repository.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario cadastrarUsuario(@Valid @RequestBody Usuario idUsuario) {
        return usuariorepository.save(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuariorepository.findAll();
    }

    @Autowired
    private UsuarioRepository usuariorepository;
}
