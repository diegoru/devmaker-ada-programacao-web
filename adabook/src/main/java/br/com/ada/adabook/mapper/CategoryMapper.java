package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.dto.category.CategoryListDTO;
import br.com.ada.adabook.dto.category.CategoryDescriptionDTO;
import br.com.ada.adabook.dto.category.CategorySaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryMapper {

    private final ModelMapper modelMapper;

    public Category toCategory(CategorySaveDTO categorySaveDTO) {
        return modelMapper.map(categorySaveDTO, Category.class);
    }

    public CategoryListDTO toCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryListDTO.class);
    }

    public CategoryDescriptionDTO toCategoryDescriptionDTO(Category category) {
        return modelMapper.map(category, CategoryDescriptionDTO.class);
    }

}
