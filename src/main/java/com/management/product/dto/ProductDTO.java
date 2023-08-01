package com.management.product.dto;

import com.management.product.entity.Category;
import com.management.product.entity.Product;

public record ProductDTO(Long id, String brand, String model , String size, String color, Double price, Integer availableStock, Category category) {

    public ProductDTO(Product product){
        this(product.getId(), product.getBrand(), product.getModel(), product.getSize(), product.getColor(), product.getPrice(), product.getAvailableStock(),
                product.getCategory());
    }
}
