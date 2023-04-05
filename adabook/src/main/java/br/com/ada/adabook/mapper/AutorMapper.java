package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Autor;
import br.com.ada.adabook.dto.AutorDescriptionDTO;
import br.com.ada.adabook.dto.AutorListDTO;
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

    public AutorDescriptionDTO toAutorDTO(Autor autor) {
        return mapper.map(autor, AutorDescriptionDTO.class);
    }

    public AutorListDTO toAutorListDTO(Autor autor) {
        return mapper.map(autor, AutorListDTO.class);
    }

    public AutorDescriptionDTO toAutorDescriptionDTO(Autor autor) {
        return mapper.map(autor, AutorDescriptionDTO.class);
    }
}
