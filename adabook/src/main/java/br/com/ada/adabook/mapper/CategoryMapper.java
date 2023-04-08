package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Category;
import br.com.ada.adabook.dto.CategoryDTO;
import br.com.ada.adabook.dto.CategorySaveDTO;
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

    public CategoryDTO toCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

}
