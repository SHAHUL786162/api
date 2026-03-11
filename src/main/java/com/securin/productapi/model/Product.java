package com.securin.productapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Integer productId;

    private String name;

    private String category;

    private String brand;

    private Float price;

    private Float rating;

    private Integer stock;

    private String description;

    private String specifications;

    private String createdAt;

    public Product() {}

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() { return price; }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRating() { return rating; }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getStock() { return stock; }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecifications() { return specifications; }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}