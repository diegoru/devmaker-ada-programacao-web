package br.com.ada.adabook.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySaveDTO {
    @NotBlank(message = "Name is a required field")
    private String name;
}
