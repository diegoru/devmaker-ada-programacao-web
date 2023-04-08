package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.AuthorDTO;
import br.com.ada.adabook.dto.AuthorSaveDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> list();
    AuthorDTO findById(Long id);
    AuthorDTO save(AuthorSaveDTO authorSaveDTO);
    AuthorDTO update(Long id, AuthorSaveDTO authorSaveDTO);
    void delete(Long id);

}
