package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.UserDTO;
import br.com.ada.adabook.dto.UserSaveDTO;
import br.com.ada.adabook.exceptions.UserNotFoundException;
import br.com.ada.adabook.mapper.UserMapper;
import br.com.ada.adabook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> list() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(userMapper::toUserDTO).toList();
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO save(UserSaveDTO userDTO) {
//        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.toUser(userDTO);
        return userMapper.toUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, UserSaveDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toUser(userDTO);
            user.setId(id);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userMapper.toUserDTO(userRepository.save(user));
        }
        throw new UserNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
