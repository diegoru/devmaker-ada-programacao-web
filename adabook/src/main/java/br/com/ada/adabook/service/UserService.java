package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.UserDescriptionDTO;
import br.com.ada.adabook.dto.UserListDTO;
import br.com.ada.adabook.dto.UserSaveDTO;

import java.util.List;

public interface UserService {

    List<UserListDTO> list();
    UserDescriptionDTO findById(Long id);
    UserDescriptionDTO save(UserSaveDTO userDTO);
    UserDescriptionDTO update(Long id, UserSaveDTO userDTO);
    void delete(Long id);

}
