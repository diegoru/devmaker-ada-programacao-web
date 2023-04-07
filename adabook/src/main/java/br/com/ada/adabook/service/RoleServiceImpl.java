package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.dto.RoleDescriptionDTO;
import br.com.ada.adabook.dto.RoleListDTO;
import br.com.ada.adabook.dto.RoleSaveDTO;
import br.com.ada.adabook.exceptions.RoleNotFoundException;
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
    public RoleDescriptionDTO findById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(RoleNotFoundException::new);
        return roleMapper.toRoleDescriptionDTO(role);
    }

    @Override
    public RoleListDTO save(RoleSaveDTO roleDTO) {
        Role role = roleMapper.toRole(roleDTO);
        return roleMapper.toRoleListDTO(roleRepository.save(role));
    }

    @Override
    public RoleListDTO update(Long id, RoleSaveDTO roleDTO) {
        Role role = roleMapper.toRole(roleDTO);
        if (roleRepository.existsById(id)) {
            role.setId(id);
            return roleMapper.toRoleListDTO(roleRepository.save(role));
        }
        throw new RoleNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!roleRepository.existsById(id)){
            throw new RoleNotFoundException();
        }
        roleRepository.deleteById(id);
    }
}
