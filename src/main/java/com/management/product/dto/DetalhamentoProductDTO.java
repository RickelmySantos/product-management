package com.management.product.dto;

import com.management.product.entity.Product;

public record DetalhamentoProductDTO(Long id,String brand, String model, String size, Double price, Integer availableStock, String color) {
    public DetalhamentoProductDTO(Product product) {
        this(product.getId(), product.getBrand(), product.getModel(), product.getSize(), product.getPrice(), product.getAvailableStock(), product.getColor());
    }
}
