package br.com.ada.adabook.controller;

import br.com.ada.adabook.dto.CategoryDTO;
import br.com.ada.adabook.dto.CategorySaveDTO;
import br.com.ada.adabook.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> list() {
        return categoryService.list();
    }

    @GetMapping("{id}")
    public CategoryDTO findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO save(@RequestBody @Valid CategorySaveDTO categorySaveDTO) {
        return categoryService.save(categorySaveDTO);
    }

    @PutMapping("{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody @Valid CategorySaveDTO categorySaveDTO) {
        return categoryService.update(id, categorySaveDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
