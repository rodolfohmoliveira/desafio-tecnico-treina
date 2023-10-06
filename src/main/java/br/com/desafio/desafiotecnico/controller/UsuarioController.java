package br.com.desafio.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.desafio.desafiotecnico.model.Usuario;
import br.com.desafio.desafiotecnico.repository.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PostMapping
    public Usuario cadastrarUsuario(@Valid @RequestBody Usuario idUsuario) {
        return usuariorepository.save(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuariorepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioPeloId(@PathVariable("id") Long idUsuario) {
        usuariorepository.deleteById(idUsuario);
    }


    @PutMapping("/{id}")
    public Usuario atualizarUsuarioPorId(@Valid @PathVariable("id") Long idUsuario, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuariorepository.findById(idUsuario);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioObj = usuarioExistente.get();

            usuarioObj.setNome(usuario.getNome());
            usuarioObj.setSobrenome(usuario.getSobrenome());
            usuarioObj.setEmail(usuario.getEmail());
            

            return usuariorepository.save(usuarioObj);
        }
        return null;

    }

    @Autowired
    private UsuarioRepository usuariorepository;
}
