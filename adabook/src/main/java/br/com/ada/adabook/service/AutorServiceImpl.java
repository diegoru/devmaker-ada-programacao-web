package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Autor;
import br.com.ada.adabook.domain.Livro;
import br.com.ada.adabook.dto.AutorDescriptionDTO;
import br.com.ada.adabook.dto.AutorListDTO;
import br.com.ada.adabook.dto.AutorSaveDTO;
import br.com.ada.adabook.exceptions.AutorNotFoundException;
import br.com.ada.adabook.mapper.AutorMapper;
import br.com.ada.adabook.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;
    private final AutorMapper mapper;

    @Override
    public List<AutorListDTO> list() {
        List<Autor> autores = (List<Autor>) repository.findAll();
        return autores.stream().map(mapper::toAutorListDTO).toList();
    }

    @Override
    public AutorDescriptionDTO findById(Long id) {
        Autor autor = repository.findById(id).orElseThrow(AutorNotFoundException::new);
        return mapper.toAutorDescriptionDTO(autor);
    }

    @Override
    public AutorDescriptionDTO save(AutorSaveDTO autorDTO) {
        Autor autor = mapper.toAutor(autorDTO);
        repository.save(autor);
        return mapper.toAutorDescriptionDTO(autor);
    }

    @Override
    public AutorDescriptionDTO update(Long id, AutorSaveDTO autorDTO) {
        Autor autor = mapper.toAutor(autorDTO);
        if (repository.existsById(id)) {
            autor.setId(id);
            repository.save(autor);
            return mapper.toAutorDescriptionDTO(autor);
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
