package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.dto.category.CategoryListDTO;
import br.com.ada.adabook.dto.category.CategoryDescriptionDTO;
import br.com.ada.adabook.dto.category.CategorySaveDTO;
import br.com.ada.adabook.exceptions.CategoryNotFoundException;
import br.com.ada.adabook.mapper.CategoryMapper;
import br.com.ada.adabook.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryListDTO> list() {
        List<Category> categorys = (List<Category>) categoryRepository.findAll();
        return categorys.stream().map(categoryMapper::toCategoryDTO).toList();
    }

    @Override
    public CategoryDescriptionDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return categoryMapper.toCategoryDescriptionDTO(category);
    }

    @Override
    public CategoryListDTO save(CategorySaveDTO categorySaveDTO) {
        Category category = categoryMapper.toCategory(categorySaveDTO);
        categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryListDTO update(Long id, CategorySaveDTO categorySaveDTO) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryMapper.toCategory(categorySaveDTO);
            category.setId(id);
            return categoryMapper.toCategoryDTO(categoryRepository.save(category));
        }
        throw new CategoryNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException();
        }
        categoryRepository.deleteById(id);
    }
}
