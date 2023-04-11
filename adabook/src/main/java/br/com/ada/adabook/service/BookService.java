package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.book.BookDetailsDTO;
import br.com.ada.adabook.dto.book.BookListDTO;
import br.com.ada.adabook.dto.book.BookSaveDTO;

import java.util.List;

public interface BookService {
    List<BookListDTO> list();
    BookDetailsDTO findById(Long id);
    BookDetailsDTO save(BookSaveDTO bookSaveDTO);
    BookDetailsDTO update(Long id, BookSaveDTO bookSaveDTO);
    void delete(Long id);

}
