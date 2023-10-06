package br.com.desafio.desafiotecnico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPost")
    private Long idPost;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeCriacao;

    @Column(name = "idAutor")
    private Long idAutor;

}