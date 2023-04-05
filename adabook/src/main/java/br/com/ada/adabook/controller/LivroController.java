package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.LivroDescriptionDTO;
import br.com.ada.adabook.dto.LivroListDTO;
import br.com.ada.adabook.dto.LivroSaveDTO;
import br.com.ada.adabook.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("livros")
public class LivroController {

    private final LivroService service;

    @GetMapping
    public List<LivroListDTO> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public LivroDescriptionDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDescriptionDTO save(@RequestBody @Valid LivroSaveDTO livroDTO) {
        return service.save(livroDTO);
    }

    @PutMapping("{id}")
    public LivroDescriptionDTO update(@PathVariable Long id, @RequestBody @Valid LivroSaveDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
