package br.com.ada.adabook.dto.role;

import br.com.ada.adabook.dto.user.UserListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDetailsDTO {

    private Long id;
    private String authority;
    private List<UserListDTO> users;
}
