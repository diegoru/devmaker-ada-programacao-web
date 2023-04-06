package br.com.ada.adabook.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivroDescriptionDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoPublicacao;
    private Integer numeroPaginas;
    private String isbn;
    private List<AutorResponseLivroDTO> autores;
}