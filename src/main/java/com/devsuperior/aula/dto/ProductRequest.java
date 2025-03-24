package com.devsuperior.aula.dto;

import java.util.List;

public record ProductRequest(
        String name,
        Double price,
        List<CategoryRequest> categories
) {
}
