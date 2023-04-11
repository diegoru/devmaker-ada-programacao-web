package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Address;
import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.AddressDTO;
import br.com.ada.adabook.dto.user.UserDetailsDTO;
import br.com.ada.adabook.dto.user.UserListDTO;
import br.com.ada.adabook.dto.user.UserSaveDTO;
import br.com.ada.adabook.exceptions.UserNotFoundException;
import br.com.ada.adabook.mapper.AddressMapper;
import br.com.ada.adabook.mapper.UserMapper;
import br.com.ada.adabook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserListDTO> list() {
        List<User> listUsers = (List<User>) userRepository.findAll();
        return listUsers.stream().map(userMapper::toUserListDTO).toList();
    }

    @Override
    public UserDetailsDTO findbyId(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDescriptionDTO(user);
    }

    @Override
    public UserDetailsDTO save(UserSaveDTO userDTO) {

        String url = "https://cdn.apicep.com/file/apicep/" + userDTO.getCode() + ".json";
        AddressDTO response = restTemplate.getForObject(url, AddressDTO.class);
        Address address = addressMapper.toAddress(response);
        User user = userMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setAddress(address);
        user.getAddress().setNumber(userDTO.getNumber());
        user.getAddress().setComplement(userDTO.getComplement());
        userRepository.save(user);
        return userMapper.toUserDescriptionDTO(user);
    }

    @Override
    public UserDetailsDTO update(Long id, UserSaveDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
