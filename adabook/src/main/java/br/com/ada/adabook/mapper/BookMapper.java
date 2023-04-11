package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Book;
import br.com.ada.adabook.dto.book.BookDetailsDTO;
import br.com.ada.adabook.dto.book.BookListDTO;
import br.com.ada.adabook.dto.book.BookSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookMapper {

    private final ModelMapper modelMapper;

    public Book toBook(BookSaveDTO bookSaveDTO) {
        return modelMapper.map(bookSaveDTO, Book.class);
    }

    public BookDetailsDTO toBookDescriptionDTO(Book book) {
        return modelMapper.map(book, BookDetailsDTO.class);
    }

    public BookListDTO toBookListDTO(Book book) {
        return modelMapper.map(book, BookListDTO.class);
    }

}
