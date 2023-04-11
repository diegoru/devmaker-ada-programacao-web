package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.user.UserDetailsDTO;
import br.com.ada.adabook.dto.user.UserListDTO;
import br.com.ada.adabook.dto.user.UserSaveDTO;
import br.com.ada.adabook.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Secured({"ADMIN", "MANAGER"})
    public List<UserListDTO> list() {
        return userService.list();
    }

    @GetMapping("{id}")
    @Secured({"ADMIN", "MANAGER"})
    public UserDetailsDTO findById(@PathVariable Long id) {
        return userService.findbyId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetailsDTO save(@RequestBody @Valid UserSaveDTO userDTO) {
        return userService.save(userDTO);
    }

}
