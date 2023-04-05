package br.com.ada.adabook.repository;

import br.com.ada.adabook.domain.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
}
