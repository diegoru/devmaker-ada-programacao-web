package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.UserDescriptionDTO;
import br.com.ada.adabook.dto.UserListDTO;
import br.com.ada.adabook.dto.UserSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public User toUser(UserSaveDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserSaveDTO toUserSaveDTO(User user) {
        return modelMapper.map(user, UserSaveDTO.class);
    }

    public UserDescriptionDTO toUserDescriptionDTO(User user) {
        return modelMapper.map(user, UserDescriptionDTO.class);
    }
    public UserListDTO toUserListDTO(User user) {
        return modelMapper.map(user, UserListDTO.class);
    }
}
