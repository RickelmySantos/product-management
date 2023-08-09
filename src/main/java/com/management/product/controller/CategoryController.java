package com.management.product.controller;

import com.management.product.dto.CategoryDTO;
import com.management.product.dto.DetailingCategoryDTO;
import com.management.product.entity.Category;
import com.management.product.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id){
        try {
            Category category = categoryService.searchForId(id);
            return ResponseEntity.ok().body(new DetailingCategoryDTO(category));
        }catch (NoSuchElementException e ){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<DetailingCategoryDTO> createdCategory(@RequestBody @Valid CategoryDTO categoryDTO, UriComponentsBuilder uriBuilder){
       var category = new Category(categoryDTO);
       categoryService.saveCategory(category);
        var uri = uriBuilder.path("/api/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailingCategoryDTO(category));
    }
}










