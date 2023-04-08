package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.dto.AuthorDTO;
import br.com.ada.adabook.dto.AuthorSaveDTO;
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
    public List<AuthorDTO> list() {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        return authors.stream().map(authorMapper::toAuthorDTO).toList();
    }

    @Override
    public AuthorDTO findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        return authorMapper.toAuthorDTO(author);
    }

    @Override
    public AuthorDTO save(AuthorSaveDTO authorSaveDTO) {
        Author author = authorMapper.toAuthor(authorSaveDTO);
        authorRepository.save(author);
        return authorMapper.toAuthorDTO(author);
    }

    @Override
    public AuthorDTO update(Long id, AuthorSaveDTO authorSaveDTO) {
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
