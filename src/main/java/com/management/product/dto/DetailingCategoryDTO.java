package com.management.product.dto;

import com.management.product.entity.Category;

import java.util.Optional;

public record DetailingCategoryDTO(Long id, String name, String description) {
    public DetailingCategoryDTO(Category category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}
