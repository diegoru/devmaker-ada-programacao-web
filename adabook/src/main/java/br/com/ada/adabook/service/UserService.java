package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.user.UserDetailsDTO;
import br.com.ada.adabook.dto.user.UserListDTO;
import br.com.ada.adabook.dto.user.UserSaveDTO;

import java.util.List;

public interface UserService {

    List<UserListDTO> list();
    UserDetailsDTO findbyId(Long id);
    UserDetailsDTO save(UserSaveDTO userDTO);
    UserDetailsDTO update(Long id, UserSaveDTO userDTO);
    void delete(Long id);

}
