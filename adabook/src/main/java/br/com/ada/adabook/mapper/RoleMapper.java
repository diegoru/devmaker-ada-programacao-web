package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.dto.RoleDescriptionDTO;
import br.com.ada.adabook.dto.RoleListDTO;
import br.com.ada.adabook.dto.RoleSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public Role toRole(RoleSaveDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }

    public RoleSaveDTO toRoleSaveDTO(Role role) {
        return modelMapper.map(role, RoleSaveDTO.class);
    }

    public RoleDescriptionDTO toRoleDescriptionDTO(Role role) {
        return modelMapper.map(role, RoleDescriptionDTO.class);
    }
    public RoleListDTO toRoleListDTO(Role role) {
        return modelMapper.map(role, RoleListDTO.class);
    }
}
