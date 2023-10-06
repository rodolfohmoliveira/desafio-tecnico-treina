package br.com.desafio.desafiotecnico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 150)
    private String sobrenome;

    @Column(nullable = false, length = 100)
    private String email;

    // @Column(nullable = false, length = 100)
    // @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    // private String email;


    @Column(nullable = false, length = 20)
    private String senha;

	
}
