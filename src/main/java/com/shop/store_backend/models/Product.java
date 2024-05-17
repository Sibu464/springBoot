package com.shop.store_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Setter
@Getter
@Table(name="products")

public class Product
{    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String title;
    private String description;
    private String condition;
    private String category;
    private Double price;
    private String currency;
    private String imageUrl;

    @ElementCollection
    @CollectionTable(name = "product_specs", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "spec")
    private List<String> specs;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getSpecs() {
        return specs;
    }

    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }
}
