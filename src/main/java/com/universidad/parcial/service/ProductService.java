package com.universidad.parcial.service;

import com.universidad.parcial.Model.Product; // Import the Product model.
import com.universidad.parcial.repository.ProductRepository; // Import the ProductRepository interface.
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection.
import org.springframework.stereotype.Service; // Marks this class as a Spring service.

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service component in Spring's context.
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor-based dependency injection. The ProductRepository is automatically injected by Spring.
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Retrieves all products from the database.
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Finds a product by its ID. Returns an Optional to handle cases where the product may not exist.
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Saves a new product to the database.
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Updates an existing product. Throws an exception if the product is not found.
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName()); // Updates the product name.
            product.setPrice(productDetails.getPrice()); // Updates the product price.
            product.setAvailable(productDetails.getAvailable()); // Updates the product availability.
            return productRepository.save(product); // Saves the updated product.
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    // Deletes a product by its ID.
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
