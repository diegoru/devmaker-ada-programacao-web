package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Author;
import br.com.ada.adabook.dto.author.AuthorDescriptionDTO;
import br.com.ada.adabook.dto.author.AuthorListDTO;
import br.com.ada.adabook.dto.author.AuthorSaveDTO;
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

    public AuthorListDTO toAuthorDTO(Author author) {
        return modelMapper.map(author, AuthorListDTO.class);
    }

    public AuthorDescriptionDTO toAuthorDescriptionDTO(Author author) {
        return modelMapper.map(author, AuthorDescriptionDTO.class);
    }

}
