package com.universidad.parcial.service;

import com.universidad.parcial.Model.Sales; // Import the Sales model.
import com.universidad.parcial.repository.SalesRepository; // Import the SalesRepository interface.
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection.
import org.springframework.stereotype.Service; // Marks this class as a Spring service.

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service component in Spring's context.
public class SalesService {

    private final SalesRepository salesRepository;

    // Constructor-based dependency injection. Spring automatically injects the SalesRepository.
    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    // Retrieves all sales records from the database.
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    // Finds a sale by its ID. Returns an Optional to handle cases where the sale may not exist.
    public Optional<Sales> getSaleById(Long id) {
        return salesRepository.findById(id);
    }

    // Saves a new sale record to the database.
    public Sales saveSale(Sales sale) {
        return salesRepository.save(sale);
    }

    // Updates an existing sale. Throws an exception if the sale is not found.
    public Sales updateSale(Long id, Sales saleDetails) {
        return salesRepository.findById(id).map(sale -> {
            sale.setNameProduct(saleDetails.getNameProduct()); // Updates the product name.
            sale.setSalePrice(saleDetails.getSalePrice()); // Updates the sale price.
            sale.setNameClient(saleDetails.getNameClient()); // Updates the client name.
            return salesRepository.save(sale); // Saves the updated sale record.
        }).orElseThrow(() -> new RuntimeException("Sale not found with id " + id));
    }

    // Deletes a sale record by its ID.
    public void deleteSale(Long id) {
        salesRepository.deleteById(id);
    }
}
