package br.com.ada.adabook.dto.book;

import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.dto.author.AuthorListDTO;
import br.com.ada.adabook.dto.category.CategoryListDTO;
import br.com.ada.adabook.dto.publisher.PublisherListDTO;
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
    private List<AuthorListDTO> authors;
    private PublisherListDTO publisher;
    private CategoryListDTO category;
}
