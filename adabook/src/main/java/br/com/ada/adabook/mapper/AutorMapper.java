package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Autor;
import br.com.ada.adabook.dto.AutorSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AutorMapper {

    private final ModelMapper mapper;

    public Autor toAutor(AutorSaveDTO dto) {
        return mapper.map(dto, Autor.class);
    }

}
