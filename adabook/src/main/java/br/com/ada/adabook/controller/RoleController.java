package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.role.RoleDetailsDTO;
import br.com.ada.adabook.dto.role.RoleListDTO;
import br.com.ada.adabook.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleListDTO> list() {
        return roleService.list();
    }

    @GetMapping("{id}")
    public RoleDetailsDTO findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

}
