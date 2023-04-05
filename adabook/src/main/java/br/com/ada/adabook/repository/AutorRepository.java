package br.com.ada.adabook.repository;

import br.com.ada.adabook.domain.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    boolean existsAutorByNome(String nome);
    Autor findByNome(String nome);

}
