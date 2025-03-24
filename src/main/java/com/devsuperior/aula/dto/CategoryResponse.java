package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;

public record CategoryResponse(
        Long id,
        String name
) {
    public CategoryResponse(Category category) {
        this(
                category.getId(),
                category.getName()
        );
    }
}
