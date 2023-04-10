package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.user.UserDescriptionDTO;
import br.com.ada.adabook.dto.user.UserListDTO;
import br.com.ada.adabook.dto.user.UserSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public User toUser(UserSaveDTO userSaveDTO) {
        return modelMapper.map(userSaveDTO, User.class);
    }

    public UserDescriptionDTO toUserDescriptionDTO(User user) {
        return modelMapper.map(user, UserDescriptionDTO.class);
    }

    public UserListDTO toUserListDTO(User user) {
        return modelMapper.map(user, UserListDTO.class);
    }

}
