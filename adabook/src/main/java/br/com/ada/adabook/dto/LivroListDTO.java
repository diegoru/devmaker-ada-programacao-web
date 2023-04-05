package br.com.ada.adabook.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroListDTO {
    private Long id;
    private String titulo;
    private String isbn;
}
