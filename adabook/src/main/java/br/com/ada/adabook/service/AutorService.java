package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.AutorDescriptionDTO;
import br.com.ada.adabook.dto.AutorListDTO;
import br.com.ada.adabook.dto.AutorSaveDTO;

import java.util.List;

public interface AutorService {
    List<AutorListDTO> list();
    AutorDescriptionDTO findById(Long id);
    AutorDescriptionDTO save(AutorSaveDTO autorDTO);
    AutorDescriptionDTO update(Long id, AutorSaveDTO autorDTO);
    void delete(Long id);

}
