package br.com.ada.adabook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorSaveDTO {

    @NotBlank
    String nome;
}
