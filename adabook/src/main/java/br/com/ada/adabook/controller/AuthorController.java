package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.AuthorDTO;
import br.com.ada.adabook.dto.AuthorSaveDTO;
import br.com.ada.adabook.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> list() {
        return authorService.list();
    }

    @GetMapping("{id}")
    public AuthorDTO findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO save(@RequestBody @Valid AuthorSaveDTO authorSaveDTO) {
        return authorService.save(authorSaveDTO);
    }

    @PutMapping("{id}")
    public AuthorDTO update(@PathVariable Long id, @RequestBody @Valid AuthorSaveDTO authorSaveDTO) {
        return authorService.update(id, authorSaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

}
