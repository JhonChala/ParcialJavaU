// This service class handles the business logic for managing distributors.

package com.universidad.parcial.service;

import com.universidad.parcial.Model.Distributors;
import com.universidad.parcial.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component for dependency injection.
public class DistributorsService {

    private final DistributorRepository distributorsRepository;

    // Constructor injection of the DistributorRepository dependency.
    @Autowired
    public DistributorsService(DistributorRepository distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }

    // Retrieves all distributors from the database.
    public List<Distributors> getAllDistributors() {
        return (List<Distributors>) distributorsRepository.findAll();
    }

    // Finds a distributor by its ID, returning an Optional to handle null values.
    public Optional<Distributors> getDistributorById(Long id) {
        return distributorsRepository.findById(id);
    }

    // Saves a new distributor or updates an existing distributor in the database.
    public Distributors saveDistributor(Distributors distributor) {
        return distributorsRepository.save(distributor);
    }

    // Updates the details of an existing distributor.
    public Distributors updateDistributor(Long id, Distributors distributorDetails) {
        // Looks for the distributor by ID and updates its fields if found.
        return distributorsRepository.findById(id).map(distributor -> {
            distributor.setName(distributorDetails.getName());
            distributor.setEmail(distributorDetails.getEmail());
            distributor.setAddress(distributorDetails.getAddress());
            distributor.setCellphone(distributorDetails.getCellphone());
            distributor.setCompany(distributorDetails.getCompany());
            return distributorsRepository.save(distributor); // Saves updated distributor.
        }).orElseThrow(() -> new RuntimeException("Distributor not found with id " + id));
    }

    // Deletes a distributor by its ID.
    public void deleteDistributor(Long id) {
        distributorsRepository.deleteById(id);
    }
}
