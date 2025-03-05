// Defines the package for the controller class
package com.universidad.parcial.controller;

// Import necessary classes for Distributors model and service
import com.universidad.parcial.Model.Distributors;
import com.universidad.parcial.service.DistributorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller to handle HTTP requests
@RestController
// Base mapping for all endpoints in this controller
@RequestMapping("/distributors")
public class DistributorsController {

    // Service layer dependency to handle business logic
    private final DistributorsService distributorsService;

    // Constructor-based dependency injection
    @Autowired
    public DistributorsController(DistributorsService distributorsService) {
        this.distributorsService = distributorsService;
    }

    // HTTP GET request to fetch all distributors
    @GetMapping
    public List<Distributors> getAllDistributors() {
        return distributorsService.getAllDistributors();
    }

    // HTTP GET request to fetch a single distributor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Distributors> getDistributorById(@PathVariable Long id) {
        return distributorsService.getDistributorById(id)
                .map(ResponseEntity::ok) // Returns 200 OK if distributor is found
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if not found
    }

    // HTTP POST request to create a new distributor
    @PostMapping
    public Distributors createDistributor(@RequestBody Distributors distributor) {
        return distributorsService.saveDistributor(distributor);
    }

    // HTTP PUT request to update an existing distributor by ID
    @PutMapping("/{id}")
    public ResponseEntity<Distributors> updateDistributor(@PathVariable Long id, @RequestBody Distributors distributorDetails) {
        try {
            Distributors updatedDistributor = distributorsService.updateDistributor(id, distributorDetails);
            return ResponseEntity.ok(updatedDistributor); // Returns 200 OK with the updated distributor
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Returns 404 if distributor not found
        }
    }

    // HTTP DELETE request to remove a distributor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistributor(@PathVariable Long id) {
        distributorsService.deleteDistributor(id);
        return ResponseEntity.ok().build(); // Returns 200 OK after deletion
    }
}
