package br.com.ada.adabook.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookListDTO {
    private Long id;
    private String title;
    private String isbn;
}
