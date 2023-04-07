package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Role;
import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.UserDescriptionDTO;
import br.com.ada.adabook.dto.UserListDTO;
import br.com.ada.adabook.dto.UserSaveDTO;
import br.com.ada.adabook.exceptions.RoleNotFoundException;
import br.com.ada.adabook.exceptions.UserNotFoundException;
import br.com.ada.adabook.mapper.UserMapper;
import br.com.ada.adabook.repository.RoleRepository;
import br.com.ada.adabook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public List<UserListDTO> list() {
        List<User> listUsers = (List<User>) userRepository.findAll();
        return listUsers.stream().map(userMapper::toUserListDTO).toList();
    }

    @Override
    public UserDescriptionDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDescriptionDTO(user);
    }

    @Override
    public UserDescriptionDTO save(UserSaveDTO userDTO) {
        existRole(userDTO);
        User user = userMapper.toUser(userDTO);
        User userSave = userRepository.save(user);
        for (Role role: userSave.getRoles()){
            Role roleRecovered = roleRepository.findById(role.getId()).get();
            role.setAuthority(roleRecovered.getAuthority());
        }
        return userMapper.toUserDescriptionDTO(userSave);
    }

    @Override
    public UserDescriptionDTO update(Long id, UserSaveDTO userDTO) {
        existRole(userDTO);
        User user = userMapper.toUser(userDTO);
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userMapper.toUserDescriptionDTO(userRepository.save(user));
        }
        throw new UserNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }

    private void existRole(UserSaveDTO userDTO) {
        userDTO.getRoles()
                .forEach(role -> roleRepository.findById(role.getId())
                        .orElseThrow(RoleNotFoundException::new));
    }
}
