package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.author.AuthorDetailsDTO;
import br.com.ada.adabook.dto.author.AuthorListDTO;
import br.com.ada.adabook.dto.author.AuthorSaveDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorListDTO> list();
    AuthorDetailsDTO findById(Long id);
    AuthorListDTO save(AuthorSaveDTO authorSaveDTO);
    AuthorListDTO update(Long id, AuthorSaveDTO authorSaveDTO);
    void delete(Long id);

}
