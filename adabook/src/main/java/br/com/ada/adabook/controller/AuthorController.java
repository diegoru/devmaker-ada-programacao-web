package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.author.AuthorDetailsDTO;
import br.com.ada.adabook.dto.author.AuthorListDTO;
import br.com.ada.adabook.dto.author.AuthorSaveDTO;
import br.com.ada.adabook.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorListDTO> list() {
        return authorService.list();
    }

    @GetMapping("{id}")
    public AuthorDetailsDTO findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ADMIN", "MANAGER"})
    public AuthorListDTO save(@RequestBody @Valid AuthorSaveDTO authorSaveDTO) {
        return authorService.save(authorSaveDTO);
    }

    @PutMapping("{id}")
    public AuthorListDTO update(@PathVariable Long id, @RequestBody @Valid AuthorSaveDTO authorSaveDTO) {
        return authorService.update(id, authorSaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ADMIN")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }


}
