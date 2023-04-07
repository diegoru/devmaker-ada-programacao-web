package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSaveDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;
}
