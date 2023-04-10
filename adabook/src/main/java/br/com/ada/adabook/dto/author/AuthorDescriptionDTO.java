package br.com.ada.adabook.dto.author;

import br.com.ada.adabook.domain.Book;
import br.com.ada.adabook.dto.book.BookListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDescriptionDTO {
    private Long id;
    private String name;
    private List<BookListDTO> books;
}
