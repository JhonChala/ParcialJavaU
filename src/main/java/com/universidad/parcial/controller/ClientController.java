// Defines the package for the controller class
package com.universidad.parcial.controller;

// Import necessary classes for Client model and service
import com.universidad.parcial.Model.Client;
import com.universidad.parcial.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller to handle HTTP requests
@RestController
// Base mapping for all endpoints in this controller
@RequestMapping("/clients")
public class ClientController {

    // Service layer dependency to handle business logic
    private final ClientService clientService;

    // Constructor-based dependency injection
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // HTTP GET request to fetch all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // HTTP GET request to fetch a single client by ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok) // Returns 200 OK if client is found
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if not found
    }

    // HTTP POST request to create a new client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    // HTTP PUT request to update an existing client by ID
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(id, clientDetails);
            return ResponseEntity.ok(updatedClient); // Returns 200 OK with the updated client
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Returns 404 if client not found
        }
    }

    // HTTP DELETE request to remove a client by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build(); // Returns 200 OK after deletion
    }
}
