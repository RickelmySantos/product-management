package com.management.product.service;

import com.management.product.entity.Product;
import com.management.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

   private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product searchForId(Long id){
    return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado!"));
    }

    public Product saveProduct(Product product){
     return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updateProduct){
    Product existingProduct = searchForId(id);
     existingProduct.setBrand(updateProduct.getBrand());
     existingProduct.setModel(updateProduct.getModel());
     existingProduct.setSize(updateProduct.getSize());
     existingProduct.setColor(updateProduct.getColor());
     existingProduct.setPrice(updateProduct.getPrice());
     existingProduct.setAvailableStock(updateProduct.getAvailableStock());
     return productRepository.save(existingProduct);
    };

    public void deleteProduct(Long id){
     Product product = searchForId(id);
     productRepository.delete(product);
    }
}
