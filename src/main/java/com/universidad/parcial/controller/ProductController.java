// Defines the package for the controller class
package com.universidad.parcial.controller;

// Imports necessary classes for Product model and service
import com.universidad.parcial.Model.Product;
import com.universidad.parcial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller for handling HTTP requests
@RestController
// Sets the base URL mapping for all endpoints in this controller
@RequestMapping("/products")
public class ProductController {

    // Service layer dependency to handle business logic
    private final ProductService productService;

    // Constructor-based dependency injection
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // HTTP GET request to retrieve a list of all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // HTTP GET request to retrieve a specific product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok) // Returns 200 OK if product is found
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if product not found
    }

    // HTTP POST request to create a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // HTTP PUT request to update an existing product by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct); // Returns 200 OK with updated product
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Returns 404 if product not found
        }
    }

    // HTTP DELETE request to remove a product by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build(); // Returns 200 OK after deletion
    }
}
