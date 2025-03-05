// This service class handles business logic for managing clients.

package com.universidad.parcial.service;

import com.universidad.parcial.Model.Client;
import com.universidad.parcial.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class ClientService {

    private final ClientRepository clientRepository;

    // Constructor injection of the ClientRepository dependency.
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Retrieves a list of all clients from the database.
    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    // Finds a client by their ID, returning an Optional to handle null values.
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Saves a new client or updates an existing client in the database.
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Updates the details of an existing client.
    public Client updateClient(Long id, Client clientDetails) {
        // Uses findById() to locate the client by ID. If found, updates their attributes.
        return clientRepository.findById(id).map(client -> {
            client.setName(clientDetails.getName());
            client.setEmail(clientDetails.getEmail());
            client.setAddress(clientDetails.getAddress());
            client.setCellphone(clientDetails.getCellphone());
            return clientRepository.save(client); // Saves updated client.
        }).orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    // Deletes a client by their ID.
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
