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
@Table(name = "tb_comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario")
    private Long idComentario;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Temporal(TemporalType.DATE)
    private Date dataDeCriacao;

    @Column(name = "idAutor")
    private Long idAutor;

    @Column(name = "idPost")
    private Long idPost;
}

