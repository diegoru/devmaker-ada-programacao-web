package br.com.ada.adabook.dto;

import br.com.ada.adabook.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDescriptionDTO {
    private Long id;
    private String authority;
    private List<UserResponseRoleDTO> users;

}
