package br.com.ada.adabook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherSaveDTO {
    @NotBlank(message = "Name is a required field")
    public String name;
}
