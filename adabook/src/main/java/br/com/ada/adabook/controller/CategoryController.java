package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.category.CategoryListDTO;
import br.com.ada.adabook.dto.category.CategoryDescriptionDTO;
import br.com.ada.adabook.dto.category.CategorySaveDTO;
import br.com.ada.adabook.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryListDTO> list() {
        return categoryService.list();
    }

    @GetMapping("{id}")
    public CategoryDescriptionDTO findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ADMIN", "MANAGER"})
    public CategoryListDTO save(@RequestBody @Valid CategorySaveDTO categorySaveDTO) {
        return categoryService.save(categorySaveDTO);
    }

    @PutMapping("{id}")
    public CategoryListDTO update(@PathVariable Long id, @RequestBody @Valid CategorySaveDTO categorySaveDTO) {
        return categoryService.update(id, categorySaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ADMIN")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
