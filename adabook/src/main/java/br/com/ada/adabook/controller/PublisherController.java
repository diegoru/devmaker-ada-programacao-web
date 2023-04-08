package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.PublisherDTO;
import br.com.ada.adabook.dto.PublisherSaveDTO;
import br.com.ada.adabook.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> list() {
        return publisherService.list();
    }

    @GetMapping("{id}")
    public PublisherDTO findById(@PathVariable Long id){
        return publisherService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherDTO save(@RequestBody @Valid PublisherSaveDTO publisherSaveDTO) {
        return publisherService.save(publisherSaveDTO);
    }

    @PutMapping("{id}")
    public PublisherDTO update(@PathVariable Long id, @RequestBody @Valid PublisherSaveDTO publisherSaveDTO) {
        return publisherService.update(id, publisherSaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }

}
