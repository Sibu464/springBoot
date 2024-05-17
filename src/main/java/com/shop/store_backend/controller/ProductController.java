package com.shop.store_backend.controller;


import com.shop.store_backend.models.Product;
import com.shop.store_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setTitle(productDetails.getTitle());
            updatedProduct.setDescription(productDetails.getDescription());
            updatedProduct.setCondition(productDetails.getCondition());
            updatedProduct.setCategory(productDetails.getCategory());
            updatedProduct.setPrice(productDetails.getPrice());
            updatedProduct.setCurrency(productDetails.getCurrency());
            updatedProduct.setImageUrl(productDetails.getImageUrl());
            updatedProduct.setSpecs(productDetails.getSpecs());
            return ResponseEntity.ok(productService.saveProduct(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
