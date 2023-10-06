package br.com.desafio.desafiotecnico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.desafiotecnico.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
    Optional<Usuario> findBynome(String nome);

 // Optional<List<Usuarios>> findByPerfil(String perfil);



}





