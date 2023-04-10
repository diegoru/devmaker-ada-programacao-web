package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.category.CategoryListDTO;
import br.com.ada.adabook.dto.category.CategoryDescriptionDTO;
import br.com.ada.adabook.dto.category.CategorySaveDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryListDTO> list();
    CategoryDescriptionDTO findById(Long id);
    CategoryListDTO save(CategorySaveDTO categorySaveDTO);
    CategoryListDTO update(Long id, CategorySaveDTO categorySaveDTO);
    void delete(Long id);

}
