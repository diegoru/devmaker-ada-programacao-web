package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Cargo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Cargo cargo;
}
