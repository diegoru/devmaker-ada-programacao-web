package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.dto.CategoryDTO;
import br.com.ada.adabook.dto.CategorySaveDTO;
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
    public List<CategoryDTO> list() {
        List<Category> categorys = (List<Category>) categoryRepository.findAll();
        return categorys.stream().map(categoryMapper::toCategoryDTO).toList();
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO save(CategorySaveDTO categorySaveDTO) {
        Category category = categoryMapper.toCategory(categorySaveDTO);
        categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO update(Long id, CategorySaveDTO categorySaveDTO) {
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
