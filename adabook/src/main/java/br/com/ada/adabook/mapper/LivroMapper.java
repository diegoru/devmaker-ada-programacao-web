package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Livro;
import br.com.ada.adabook.dto.LivroDescriptionDTO;
import br.com.ada.adabook.dto.LivroListDTO;
import br.com.ada.adabook.dto.LivroSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LivroMapper {

    private final ModelMapper mapper;

    public Livro toLivro(LivroSaveDTO dto) {
        return mapper.map(dto, Livro.class);
    }

    public LivroSaveDTO toLivroDTO(Livro livro){
        return mapper.map(livro, LivroSaveDTO.class);
    }

    public LivroListDTO toLivroListDTO(Livro livro){
        return mapper.map(livro, LivroListDTO.class);
    }

    public LivroDescriptionDTO toLivroDescriptionDTO(Livro livro) {
        return mapper.map(livro, LivroDescriptionDTO.class);
    }
}
