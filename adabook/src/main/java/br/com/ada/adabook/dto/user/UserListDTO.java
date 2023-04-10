package br.com.ada.adabook.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;

}
