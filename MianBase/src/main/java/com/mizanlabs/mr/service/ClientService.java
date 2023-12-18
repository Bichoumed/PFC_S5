package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.Client;
import com.mizanlabs.mr.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Rename this method to match the controller
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Rename this method to match the controller
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Rename this method to match the controller
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Rename this method to match the controller and change the return type to Optional<Client>
    public Optional<Client> updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            client.setName(clientDetails.getName());
            client.setEmail(clientDetails.getEmail());
            // Set other fields...
            return clientRepository.save(client);
        });
    }

    // Change this method to return boolean to match the controller expectation
    public boolean deleteClient(Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists) {
            return false;
        }
        clientRepository.deleteById(id);
        return true;
    }
}
