// Defines the package for the controller class
package com.universidad.parcial.controller;

// Imports the Sales model and SalesService for handling business logic
import com.universidad.parcial.Model.Sales;
import com.universidad.parcial.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller, making it capable of handling HTTP requests
@RestController
// Sets the base URL for all endpoints in this controller (e.g., /sales)
@RequestMapping("/sales")
public class SalesController {

    // Dependency on SalesService to handle business logic
    private final SalesService salesService;

    // Constructor-based dependency injection to inject SalesService into the controller
    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // Handles HTTP GET requests to /sales — retrieves all sales records
    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    // Handles HTTP GET requests to /sales/{id} — retrieves a sale by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Long id) {
        // If sale exists, return 200 OK with the sale data; otherwise, return 404 Not Found
        return salesService.getSaleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Handles HTTP POST requests to /sales — creates a new sale
    @PostMapping
    public Sales createSale(@RequestBody Sales sale) {
        return salesService.saveSale(sale);
    }

    // Handles HTTP PUT requests to /sales/{id} — updates an existing sale
    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSale(@PathVariable Long id, @RequestBody Sales saleDetails) {
        try {
            Sales updatedSale = salesService.updateSale(id, saleDetails);
            return ResponseEntity.ok(updatedSale); // Return 200 OK with the updated sale
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Return 404 if the sale wasn't found
        }
    }

    // Handles HTTP DELETE requests to /sales/{id} — deletes a sale by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        salesService.deleteSale(id);
        return ResponseEntity.ok().build(); // Return 200 OK after deletion
    }
}
