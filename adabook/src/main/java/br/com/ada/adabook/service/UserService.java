package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.UserDTO;
import br.com.ada.adabook.dto.UserSaveDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> list();
    UserDTO findById(Long id);
    UserDTO save(UserSaveDTO userDTO);
    UserDTO update(Long id, UserSaveDTO userDTO);
    void delete(Long id);

}
