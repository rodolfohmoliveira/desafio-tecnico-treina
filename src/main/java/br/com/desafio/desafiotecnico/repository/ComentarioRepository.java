package br.com.desafio.desafiotecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.desafio.desafiotecnico.model.Comentario;
import br.com.desafio.desafiotecnico.model.Post;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPost(Post post);
}
