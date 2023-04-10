package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.dto.author.AuthorDescriptionDTO;
import br.com.ada.adabook.dto.author.AuthorListDTO;
import br.com.ada.adabook.dto.author.AuthorSaveDTO;
import br.com.ada.adabook.exceptions.AuthorNotFoundException;
import br.com.ada.adabook.mapper.AuthorMapper;
import br.com.ada.adabook.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorListDTO> list() {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        return authors.stream().map(authorMapper::toAuthorDTO).toList();
    }

    @Override
    public AuthorDescriptionDTO findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        return authorMapper.toAuthorDescriptionDTO(author);
    }

    @Override
    public AuthorListDTO save(AuthorSaveDTO authorSaveDTO) {
        Author author = authorMapper.toAuthor(authorSaveDTO);
        authorRepository.save(author);
        return authorMapper.toAuthorDTO(author);
    }

    @Override
    public AuthorListDTO update(Long id, AuthorSaveDTO authorSaveDTO) {
        if (authorRepository.existsById(id)) {
            Author author = authorMapper.toAuthor(authorSaveDTO);
            author.setId(id);
            return authorMapper.toAuthorDTO(authorRepository.save(author));
        }
        throw new AuthorNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException();
        }
            authorRepository.deleteById(id);
    }
}
