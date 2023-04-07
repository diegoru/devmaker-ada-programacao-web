package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.RoleDescriptionDTO;
import br.com.ada.adabook.dto.RoleListDTO;
import br.com.ada.adabook.dto.RoleSaveDTO;
import br.com.ada.adabook.service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleServiceImpl userService;

    @GetMapping
    public List<RoleListDTO> list() {
        return userService.list();
    }

    @GetMapping("{id}")
    public RoleDescriptionDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleListDTO save(@RequestBody RoleSaveDTO dto) {
        return userService.save(dto);
    }

    @PutMapping("{id}")
    public RoleListDTO update(@PathVariable Long id, @RequestBody RoleSaveDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
