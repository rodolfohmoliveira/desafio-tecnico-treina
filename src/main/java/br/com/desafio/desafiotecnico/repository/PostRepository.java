package br.com.desafio.desafiotecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafiotecnico.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
