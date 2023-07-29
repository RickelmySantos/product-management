package com.management.product.controller;

import com.management.product.dto.DetalhamentoProductDTO;
import com.management.product.dto.ProductDTO;
import com.management.product.entity.Product;
import com.management.product.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity createdProducts(@RequestBody @Valid ProductDTO productDTO, UriComponentsBuilder uriBuilder){
    var product = new Product(productDTO);
    productRepository.save(product);
    var uri = uriBuilder.path("/api/products/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(new DetalhamentoProductDTO(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity listProduct(@PathVariable(value = "id") Long id){

        var product = productRepository.findById(id);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");

        }else {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }

    }

}
