package com.securin.productapi.service;

import com.securin.productapi.model.Product;
import com.securin.productapi.repository.ProductRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void loadProducts() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream input =
                    new ClassPathResource("products.json").getInputStream();

            List<Product> products =
                    mapper.readValue(input,
                            new TypeReference<List<Product>>() {});

            repository.saveAll(products);

            System.out.println("Products loaded successfully");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}