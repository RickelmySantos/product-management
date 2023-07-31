package com.management.product.entity;

import com.management.product.dto.ProductDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(nullable = false, length = 30)
    private String size;
    @Column(nullable = false, length = 30)
    private String color;
    @Column(nullable = false, length = 255)
    private Double price;
    private Integer availableStock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Long id, String brand, String model, String size, String color, Double price, Integer availableStock , Category category) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.color = color;
        this.price = price;
        this.availableStock = availableStock;
        this.category = category;
    }

    public Product(ProductDTO productDTO) {
        this.id = productDTO.id();
        this.brand = productDTO.brand();
        this.model = productDTO.model();
        this.size = productDTO.size();
        this.color = productDTO.color();
        this.price = productDTO.price();
        this.availableStock = productDTO.availableStock();
        this.category = productDTO.category();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

