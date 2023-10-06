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

    @ManyToOne // Relacionamento com Post (muitos Comentarios pertencem a um único Post)
    @JoinColumn(name = "idPost") // Nome da coluna que faz referência ao Post na tabela de Comentarios
    private Post post; // Atributo post representando o Post ao qual este Comentario está associado

    // Construtores, getters e setters
}
