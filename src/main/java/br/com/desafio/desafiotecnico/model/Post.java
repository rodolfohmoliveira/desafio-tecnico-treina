package br.com.desafio.desafiotecnico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @ManyToOne // Relacionamento com Usuario (um Post tem um único autor)
    @JoinColumn(name = "idAutor") // Nome da coluna que faz referência ao autor na tabela de Posts
    private Usuario autor; // Atributo autor representando o autor do Post

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios; // Lista de Comentarios associados a este Post

    // Construtores, getters e setters

    // // Método para definir a data de criação no formato "dd/MM/YYYY"
    // public void setDataDeCriacaoFormatted(String dataDeCriacaoFormatted) {
    //     try {
    //         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    //         this.dataDeCriacao = dateFormat.parse(dataDeCriacaoFormatted);
    //     } catch (Exception e) {
    //         throw new IllegalArgumentException("Formato de data inválido");
    //     }
    // }
}
