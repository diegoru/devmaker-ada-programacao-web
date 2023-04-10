package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.book.BookDescriptionDTO;
import br.com.ada.adabook.dto.book.BookListDTO;
import br.com.ada.adabook.dto.book.BookSaveDTO;
import br.com.ada.adabook.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookListDTO> list() {
        return bookService.list();
    }

    @GetMapping("{id}")
    public BookDescriptionDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ADMIN", "MANAGER"})
    public BookDescriptionDTO save(@Valid @RequestBody BookSaveDTO bookSaveDTO) {
        return bookService.save(bookSaveDTO);
    }

    @PutMapping("{id}")
    public BookDescriptionDTO update(@PathVariable Long id, @Valid @RequestBody BookSaveDTO bookSaveDTO) {
        return bookService.update(id, bookSaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ADMIN")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

}
