package com.management.product.dto;

import com.management.product.entity.Category;

public record CategoryDTO(Long id, String name, String description) {
    public CategoryDTO(Category category){
        this(category.getId(), category.getName(), category.getDescription());
    }
}
