package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> list();
    Autor findById(Long id);
    Autor save(Autor autor);
    Autor update(Long id, Autor autor);
    void delete(Long id);

}
