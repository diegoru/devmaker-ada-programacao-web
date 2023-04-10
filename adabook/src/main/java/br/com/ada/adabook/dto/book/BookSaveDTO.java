package br.com.ada.adabook.dto.book;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.domain.Publisher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSaveDTO {
    @NotBlank(message = "Title is a required field")
    private String title;
    private String description;
    private Integer publicationYear;
    private Integer numberPages;
    @NotBlank(message = "ISBN is a required field")
    private String isbn;
    @NotEmpty(message = "Author is a required field")
    @NotNull
    private List<Author> authors;
    @NotNull(message = "Publisher is a required field")
    private Publisher publisher;
    @NotNull(message = "Category is a required field")
    private Category category;
}
