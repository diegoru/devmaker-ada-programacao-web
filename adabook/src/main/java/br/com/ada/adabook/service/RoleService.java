package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.role.RoleDetailsDTO;
import br.com.ada.adabook.dto.role.RoleListDTO;
import br.com.ada.adabook.dto.role.RoleSaveDTO;

import java.util.List;

public interface RoleService {

    List<RoleListDTO> list();
    RoleDetailsDTO findById(Long id);
    RoleDetailsDTO save(RoleSaveDTO roleSaveDTO);
    RoleDetailsDTO update(Long id, RoleSaveDTO roleSaveDTO);
    void delete(Long id);

}
