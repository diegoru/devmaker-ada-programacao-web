package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.dto.AuthorDTO;
import br.com.ada.adabook.dto.AuthorSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthorMapper {

    private final ModelMapper modelMapper;

    public Author toAuthor(AuthorSaveDTO authorSaveDTO) {
        return modelMapper.map(authorSaveDTO, Author.class);
    }

    public AuthorDTO toAuthorDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

}
