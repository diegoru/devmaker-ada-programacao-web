package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.dto.role.RoleDetailsDTO;
import br.com.ada.adabook.dto.role.RoleListDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleListDTO toRoleListDTO(Role role) {
        return modelMapper.map(role, RoleListDTO.class);
    }

}
