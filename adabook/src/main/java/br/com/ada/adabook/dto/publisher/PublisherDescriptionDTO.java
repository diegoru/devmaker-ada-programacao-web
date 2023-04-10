package br.com.ada.adabook.dto.publisher;

import br.com.ada.adabook.dto.book.BookListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublisherDescriptionDTO {
    private Long id;
    private String name;
    private List<BookListDTO> books;
}
