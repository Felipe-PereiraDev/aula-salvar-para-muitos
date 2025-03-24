package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Product;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        Double price,
        List<CategoryResponse> categories
) {
    public ProductResponse(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategories().stream().map(a -> new CategoryResponse(a)).toList()
        );
    }
}
