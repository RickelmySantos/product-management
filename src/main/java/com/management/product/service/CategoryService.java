package com.management.product.service;

import com.management.product.dto.CategoryDTO;
import com.management.product.entity.Category;
import com.management.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category searchForId(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Categoria inexistente no banco de dados"));
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, CategoryDTO updateCategory){
        Category existingCategory = searchForId(id);
        if(updateCategory.name() != null){
            existingCategory.setName(updateCategory.name());
        }
        if(updateCategory.description() != null){
            existingCategory.setDescription(updateCategory.description());
        }
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id){
        Category category = searchForId(id);
        categoryRepository.delete(category);
    }
}
