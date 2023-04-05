package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.LivroDescriptionDTO;
import br.com.ada.adabook.dto.LivroListDTO;
import br.com.ada.adabook.dto.LivroSaveDTO;

import java.util.List;

public interface LivroService {

    List<LivroListDTO> list();
    LivroDescriptionDTO findById(Long id);
    LivroDescriptionDTO save(LivroSaveDTO livroDTO);
    LivroDescriptionDTO update(Long id, LivroSaveDTO livroDTO);
    void delete(Long id);

}
