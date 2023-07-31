package com.management.product.dto;

import com.management.product.entity.Category;

public record ProductDTO(Long id, String brand, String model , String size, String color, Double price, Integer availableStock, Category category) {
}
