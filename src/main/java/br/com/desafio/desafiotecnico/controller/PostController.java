package br.com.desafio.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.desafio.desafiotecnico.dto.PostDTO;
import br.com.desafio.desafiotecnico.exception.AutorNaoEncontradoException;
import br.com.desafio.desafiotecnico.model.Comentario;
import br.com.desafio.desafiotecnico.model.Post;
import br.com.desafio.desafiotecnico.model.Usuario;
import br.com.desafio.desafiotecnico.repository.ComentarioRepository;
import br.com.desafio.desafiotecnico.repository.PostRepository;
import br.com.desafio.desafiotecnico.repository.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.Date;


@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public List<Post> listarPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarPostPorId(@PathVariable("id") Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Post> criarPost(@Valid @RequestBody PostDTO postDTO) {
        Optional<Usuario> authorOptional = userRepository.findById(postDTO.getAuthorId());
        if (authorOptional.isPresent()) {
            Usuario author = authorOptional.get();
            Post post = new Post();
            post.setTitulo(postDTO.getTitulo());
            post.setConteudo(postDTO.getConteudo());
            post.setAutor(author);

            // Defina a data de criação como a data atual
            post.setDataDeCriacao(new Date()); // Isso adiciona a data atual

            Post savedPost = postRepository.save(post);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
        } else {
            throw new AutorNaoEncontradoException();
        }
    }

    // @PostMapping
    // public ResponseEntity<Post> criarPost(@Valid @RequestBody PostDTO postDTO) {
    // Optional<Usuario> authorOptional =
    // userRepository.findById(postDTO.getAuthorId());
    // if (authorOptional.isPresent()) {
    // Usuario author = authorOptional.get();
    // Post post = new Post();
    // post.setTitulo(postDTO.getTitulo());
    // post.setConteudo(postDTO.getConteudo());
    // post.setAutor(author); // Configura o autor usando o relacionamento mapeado

    // Post savedPost = postRepository.save(post);

    // return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    // } else {
    // throw new AutorNaoEncontradoException();
    // }
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Post> atualizarPostPorId(@PathVariable("id") Long id, @Valid @RequestBody PostDTO postDTO) {
        Optional<Post> postExistente = postRepository.findById(id);

        if (postExistente.isPresent()) {
            Post post = postExistente.get();

            // Verifique se o autor existe e atualize apenas se o ID do autor estiver
            // presente no DTO.
            if (postDTO.getAuthorId() != null) {
                Optional<Usuario> authorOptional = userRepository.findById(postDTO.getAuthorId());

                if (authorOptional.isPresent()) {
                    Usuario author = authorOptional.get();
                    post.setAutor(author);
                } else {
                    throw new AutorNaoEncontradoException();
                }
            }

            // Atualize os outros campos do Post
            post.setTitulo(postDTO.getTitulo());
            post.setConteudo(postDTO.getConteudo());

            // Salve a atualização do Post
            Post updatedPost = postRepository.save(post);

            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostPorId(@PathVariable("id") Long id) {
        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();

            // Exclua os comentários associados ao Post
            List<Comentario> comentarios = comentarioRepository.findByPost(post);
            comentarioRepository.deleteAll(comentarios);

            // Exclua o próprio Post
            postRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository userRepository;

}
