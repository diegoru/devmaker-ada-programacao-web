package br.com.ada.adabook.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutorDescriptionDTO {
    private Long id;
    private String nome;
    private List<LivroListDTO> livros;
}
