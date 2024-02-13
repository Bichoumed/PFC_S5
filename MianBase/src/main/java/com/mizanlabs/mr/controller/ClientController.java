package com.mizanlabs.mr.controller;

import com.mizanlabs.mr.entities.Client;
import com.mizanlabs.mr.entities.Contact;
import com.mizanlabs.mr.service.ClientService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Create a new client

    // Get all clients
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.createClient(client);
        return ResponseEntity.ok(savedClient);
    }

    // Get a single client by ID
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    // Update a client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a client
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable Long clientId) {
        List<Contact> clientContacts = clientService.getClientContacts(clientId);
        return ResponseEntity.ok(clientContacts);
    }
    
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    @DeleteMapping("/{clientId}/contacts/{contactId}")
    @Transactional
    public ResponseEntity<Void> deleteClientContact(@PathVariable Long clientId, @PathVariable Long contactId) {
        if (clientService.deleteClientContact(clientId, contactId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    @PostMapping("/{clientId}/add-contact/{contactId}")

    public ResponseEntity<Void> addContactToClient(@PathVariable Long clientId, @PathVariable Long contactId) {
    	
    	clientService.addContactToClient(clientId, contactId);
        return ResponseEntity.ok().build();
    }
}
