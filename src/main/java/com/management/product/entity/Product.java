package com.management.product.entity;

import com.management.product.dto.ProductDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "Product")
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

    public Product(){

    }

    public Product(Long id, String brand, String model, String size, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.color = color;
    }

    public Product(ProductDTO productDTO) {
        this.id = productDTO.id();
        this.brand = productDTO.brand();
        this.model = productDTO.model();
        this.size = productDTO.size();
        this.color = productDTO.color();
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
