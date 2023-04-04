package br.com.ada.adabook.controller;

import br.com.ada.adabook.domain.Autor;
import br.com.ada.adabook.dto.AutorSaveDTO;
import br.com.ada.adabook.mapper.AutorMapper;
import br.com.ada.adabook.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;
    private final AutorMapper mapper;

    @GetMapping
    public List<Autor> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public Autor findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor save(@Valid @RequestBody AutorSaveDTO dto) {
        Autor autor = mapper.toAutor(dto);
        return service.save(autor);
    }
    @PutMapping("{id}")
    public Autor update(@PathVariable Long id, @RequestBody AutorSaveDTO dto) {
        Autor autor = mapper.toAutor(dto);
        return service.update(id, autor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
