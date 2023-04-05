package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.AutorDescriptionDTO;
import br.com.ada.adabook.dto.AutorListDTO;
import br.com.ada.adabook.dto.AutorSaveDTO;
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

    @GetMapping
    public List<AutorListDTO> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public AutorDescriptionDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorDescriptionDTO save(@Valid @RequestBody AutorSaveDTO dto) {
        return service.save(dto);
    }
    @PutMapping("{id}")
    public AutorDescriptionDTO update(@PathVariable Long id, @RequestBody AutorSaveDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
