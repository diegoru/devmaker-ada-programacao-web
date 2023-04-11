package br.com.ada.adabook.dto.user;

import br.com.ada.adabook.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private Address address;

}
