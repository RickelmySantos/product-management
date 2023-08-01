package com.management.product.controller;

import com.management.product.dto.DetalhamentoProductDTO;
import com.management.product.dto.ProductDTO;
import com.management.product.entity.Product;
import com.management.product.repository.ProductRepository;
import com.management.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    private ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity createdProducts(@RequestBody @Valid ProductDTO productDTO, UriComponentsBuilder uriBuilder){
    var product = new Product(productDTO);
    productService.saveProduct(product);
    var uri = uriBuilder.path("/api/products/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(new DetalhamentoProductDTO(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listProduct(@PathVariable(value = "id") Long id){
        try {
            var product = productService.searchForId(id);
            return ResponseEntity.ok(new DetalhamentoProductDTO(product));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetalhamentoProductDTO>  updateProduct(@PathVariable Long id,@RequestBody @Valid ProductDTO productDTO){
            try {
                Product product = productService.updateProduct(id, new Product(productDTO));
                return ResponseEntity.ok(new DetalhamentoProductDTO(product));
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
