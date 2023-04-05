package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Livro;
import br.com.ada.adabook.dto.LivroDescriptionDTO;
import br.com.ada.adabook.dto.LivroListDTO;
import br.com.ada.adabook.dto.LivroSaveDTO;
import br.com.ada.adabook.exceptions.LivroNotFoundException;
import br.com.ada.adabook.mapper.LivroMapper;
import br.com.ada.adabook.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;
    private final AutorService autorService;

    @Override
    public List<LivroListDTO> list() {
        List<Livro> listaLivros = (List<Livro>) repository.findAll();
        return listaLivros.stream().map(mapper::toLivroListDTO).toList();
    }

    @Override
    public LivroDescriptionDTO findById(Long id) {
        Livro livro = repository.findById(id).orElseThrow(LivroNotFoundException::new);
        return mapper.toLivroDescriptionDTO(livro);
    }

    @Override
    public LivroDescriptionDTO save(LivroSaveDTO livroDTO) {
        Livro livro = mapper.toLivro(livroDTO);
        livro.getAutores().forEach(autor -> autorService.findById(autor.getId()));
        return mapper.toLivroDescriptionDTO(repository.save(livro));
    }

    @Override
    public LivroDescriptionDTO update(Long id, LivroSaveDTO livroDTO) {
        Livro livro = mapper.toLivro(livroDTO);
        if (repository.existsById(id)){
            livro.getAutores().forEach(autor -> autorService.findById(autor.getId()));
            livro.setId(id);
            repository.save(livro);
            return mapper.toLivroDescriptionDTO(livro);
        }
        throw new LivroNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new LivroNotFoundException();
        }
        repository.deleteById(id);
    }

}
