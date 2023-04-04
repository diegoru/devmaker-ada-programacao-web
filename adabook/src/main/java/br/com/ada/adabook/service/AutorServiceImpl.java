package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Autor;
import br.com.ada.adabook.exceptions.AutorNotFoundException;
import br.com.ada.adabook.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;

    @Override
    public List<Autor> list() {
        return (List<Autor>) repository.findAll();
    }

    @Override
    public Autor findById(Long id) {
        return repository.findById(id).orElseThrow(AutorNotFoundException::new);
    }

    @Override
    public Autor save(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Autor update(Long id, Autor autor) {
        if (repository.existsById(id)){
            autor.setId(id);
            return repository.save(autor);
        }
        throw new AutorNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AutorNotFoundException();
        }
        repository.deleteById(id);
    }
}
