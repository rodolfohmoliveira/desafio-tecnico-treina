package br.com.desafio.desafiotecnico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String conteudo;

    @NotNull
    private Long authorId; // Alterado para o mesmo nome da entidade Usuario
}
