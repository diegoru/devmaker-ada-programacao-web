package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.book.BookDescriptionDTO;
import br.com.ada.adabook.dto.book.BookListDTO;
import br.com.ada.adabook.dto.book.BookSaveDTO;

import java.util.List;

public interface BookService {
    List<BookListDTO> list();
    BookDescriptionDTO findById(Long id);
    BookDescriptionDTO save(BookSaveDTO bookSaveDTO);
    BookDescriptionDTO update(Long id, BookSaveDTO bookSaveDTO);
    void delete(Long id);

}
