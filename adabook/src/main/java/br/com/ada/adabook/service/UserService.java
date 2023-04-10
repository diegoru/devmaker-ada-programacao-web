package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.user.UserDescriptionDTO;
import br.com.ada.adabook.dto.user.UserListDTO;
import br.com.ada.adabook.dto.user.UserSaveDTO;

import java.util.List;

public interface UserService {

    List<UserListDTO> list();
    UserDescriptionDTO findbyId(Long id);
    UserDescriptionDTO save(UserSaveDTO userDTO);
    UserDescriptionDTO update(Long id, UserSaveDTO userDTO);
    void delete(Long id);

}
