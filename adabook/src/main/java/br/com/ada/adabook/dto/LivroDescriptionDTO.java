package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Autor;
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
    private List<Autor> autores;
}