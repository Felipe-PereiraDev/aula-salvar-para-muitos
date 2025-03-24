package com.devsuperior.aula.service;

import com.devsuperior.aula.dto.ProductRequest;
import com.devsuperior.aula.dto.ProductResponse;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public ProductResponse create(ProductRequest productRequest) {
        Product product = new Product(productRequest);
        productRequest.categories().forEach(cat -> {
            Category category = categoryRepository.getReferenceById(cat.id());
            product.addCategory(category);
        });
        productRepository.save(product);
        return new ProductResponse(product);
    }
}
