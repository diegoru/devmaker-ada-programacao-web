package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.dto.role.RoleDetailsDTO;
import br.com.ada.adabook.dto.role.RoleListDTO;
import br.com.ada.adabook.dto.role.RoleSaveDTO;
import br.com.ada.adabook.mapper.RoleMapper;
import br.com.ada.adabook.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public List<RoleListDTO> list() {
        List<Role> listRoles = (List<Role>) roleRepository.findAll();
        return listRoles.stream().map(roleMapper::toRoleListDTO).toList();
    }

    @Override
    public RoleDetailsDTO findById(Long id) {
        return null;
    }

    @Override
    public RoleDetailsDTO save(RoleSaveDTO roleSaveDTO) {
        return null;
    }

    @Override
    public RoleDetailsDTO update(Long id, RoleSaveDTO roleSaveDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
