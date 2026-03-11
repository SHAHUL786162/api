package com.securin.productapi.repository;

import com.securin.productapi.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoryIgnoreCase(String category);

    List<Product> findByRatingGreaterThanEqual(Float rating);
    List<Product> findByRatingEqual(Float rating);
    
}