package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.CategoryDTO;
import br.com.ada.adabook.dto.CategorySaveDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> list();
    CategoryDTO findById(Long id);
    CategoryDTO save(CategorySaveDTO categorySaveDTO);
    CategoryDTO update(Long id, CategorySaveDTO categorySaveDTO);
    void delete(Long id);

}
