package com.devsuperior.aula.controller;

import com.devsuperior.aula.dto.ProductRequest;
import com.devsuperior.aula.dto.ProductResponse;
import com.devsuperior.aula.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        var createdProduct = productService.create(productRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdProduct.id()).toUri();
        return ResponseEntity.created(uri).body(createdProduct);
    }
}
