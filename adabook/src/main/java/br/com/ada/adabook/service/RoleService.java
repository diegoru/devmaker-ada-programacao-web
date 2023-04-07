package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.RoleDescriptionDTO;
import br.com.ada.adabook.dto.RoleListDTO;
import br.com.ada.adabook.dto.RoleSaveDTO;

import java.util.List;

public interface RoleService {

    List<RoleListDTO> list();
    RoleDescriptionDTO findById(Long id);
    RoleListDTO save(RoleSaveDTO roleDTO);
    RoleListDTO update(Long id, RoleSaveDTO roleDTO);
    void delete(Long id);

}
