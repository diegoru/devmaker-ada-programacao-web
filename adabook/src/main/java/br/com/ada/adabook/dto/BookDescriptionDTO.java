package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDescriptionDTO {
    private Long id;
    private String title;
    private String description;
    private Integer publicationYear;
    private Integer numberPages;
    private String isbn;
    private List<AuthorDTO> authors;
    private PublisherDTO publisher;
}
