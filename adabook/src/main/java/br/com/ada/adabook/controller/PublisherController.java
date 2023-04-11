package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.publisher.PublisherDetailsDTO;
import br.com.ada.adabook.dto.publisher.PublisherListDTO;
import br.com.ada.adabook.dto.publisher.PublisherSaveDTO;
import br.com.ada.adabook.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public List<PublisherListDTO> list() {
        return publisherService.list();
    }

    @GetMapping("{id}")
    public PublisherDetailsDTO findById(@PathVariable Long id){
        return publisherService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ADMIN", "MANAGER"})
    public PublisherListDTO save(@RequestBody @Valid PublisherSaveDTO publisherSaveDTO) {
        return publisherService.save(publisherSaveDTO);
    }

    @PutMapping("{id}")
    public PublisherListDTO update(@PathVariable Long id, @RequestBody @Valid PublisherSaveDTO publisherSaveDTO) {
        return publisherService.update(id, publisherSaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ADMIN")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }

}
