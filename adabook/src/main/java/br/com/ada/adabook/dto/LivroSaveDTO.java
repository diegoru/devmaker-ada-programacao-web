package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivroSaveDTO {
    @NotBlank(message = "Titulo é um campo obrigatório")
    private String titulo;
    @NotBlank(message = "Descrição é um campo obrigatório")
    private String descricao;
    @NotNull(message = "Ano publicação é um campo obrigatório")
    private Integer anoPublicacao;
    @NotNull(message = "Número de páginas é um campo obrigatório")
    private Integer numeroPaginas;
    @NotBlank(message = "ISBN é um campo obrigatório")
    private String isbn;
    @NotEmpty(message = "Autor é um campo obrigatório")
    @NotNull
    private List<Autor> autores;
}
