package br.com.ada.adabook.dto.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorSaveDTO {
    @NotBlank(message = "Name is a required field")
    private String name;
}
