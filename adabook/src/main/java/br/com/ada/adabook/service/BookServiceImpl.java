package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.domain.Book;
import br.com.ada.adabook.domain.Publisher;
import br.com.ada.adabook.dto.BookDescriptionDTO;
import br.com.ada.adabook.dto.BookListDTO;
import br.com.ada.adabook.dto.BookSaveDTO;
import br.com.ada.adabook.exceptions.AuthorNotFoundException;
import br.com.ada.adabook.exceptions.BookNotFoundException;
import br.com.ada.adabook.exceptions.PublisherNotFoundException;
import br.com.ada.adabook.mapper.BookMapper;
import br.com.ada.adabook.repository.AuthorRepository;
import br.com.ada.adabook.repository.BookRepository;
import br.com.ada.adabook.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public List<BookListDTO> list() {
        List<Book> listBooks = (List<Book>) bookRepository.findAll();
        return listBooks.stream().map(bookMapper::toBookListDTO).toList();
    }

    @Override
    public BookDescriptionDTO findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookMapper.toBookDescriptionDTO(book);
    }

    @Override
    public BookDescriptionDTO save(BookSaveDTO bookSaveDTO) {
        Book book = bookMapper.toBook(bookSaveDTO);
        book.getAuthors().forEach(author -> authorRepository.findById(author.getId()).orElseThrow(AuthorNotFoundException::new));
        getPublisherName(book);
        Book saveBook = bookRepository.save(book);
        getAuthorName(saveBook);
        return bookMapper.toBookDescriptionDTO(saveBook);
    }

    @Override
    public BookDescriptionDTO update(Long id, BookSaveDTO bookSaveDTO) {
        if (bookRepository.existsById(id)) {
            Book book = bookMapper.toBook(bookSaveDTO);
            book.setId(id);
            bookRepository.save(book);
            getAuthorName(book);
            getPublisherName(book);
            return bookMapper.toBookDescriptionDTO(book);
        }
        throw new BookNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    private void getAuthorName(Book saveBook) {
        for (Author author : saveBook.getAuthors()) {
            author.setName(authorRepository.findById(author.getId()).get().getName());
        }
    }

    private void getPublisherName(Book book) {
        Publisher publisher = publisherRepository.findById(book.getPublisher().getId()).orElseThrow(PublisherNotFoundException::new);
        book.setPublisher(publisher);
    }
}
