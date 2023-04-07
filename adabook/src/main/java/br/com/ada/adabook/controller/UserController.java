package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.UserDescriptionDTO;
import br.com.ada.adabook.dto.UserListDTO;
import br.com.ada.adabook.dto.UserSaveDTO;
import br.com.ada.adabook.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public List<UserListDTO> list() {
        return userService.list();
    }

    @GetMapping("{id}")
    public UserDescriptionDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDescriptionDTO save(@RequestBody UserSaveDTO dto) {
        return userService.save(dto);
    }

    @PutMapping("{id}")
    public UserDescriptionDTO update(@PathVariable Long id, @RequestBody UserSaveDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
