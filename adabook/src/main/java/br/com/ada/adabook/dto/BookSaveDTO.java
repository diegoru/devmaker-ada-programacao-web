package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Author;
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
    private Publisher publisher;
}
