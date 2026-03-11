package com.securin.productapi.controller;

import com.securin.productapi.model.Product;
import com.securin.productapi.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int limit
    ) {

        Pageable pageable =
                PageRequest.of(page - 1, limit,
                        Sort.by("rating").descending());

        return repository.findAll(pageable);
    }
    
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Float rating
    ) {

        if (name != null)
            return repository.findByNameContainingIgnoreCase(name);

        if (category != null)
            return repository.findByCategoryIgnoreCase(category);

        if (rating != null)
            return repository.findByRatingGreaterThanEqual(rating);

        return repository.findAll();
    }

}