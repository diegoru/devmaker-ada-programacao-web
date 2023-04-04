package br.com.ada.adabook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDTO {
    private String mensagem;
}
