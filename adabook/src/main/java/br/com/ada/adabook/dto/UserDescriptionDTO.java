package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDescriptionDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<RoleResponseUserDTO> roles;
}
