package com.mizanlabs.mr.controller;

import com.mizanlabs.mr.entities.Devis;
import com.mizanlabs.mr.service.DevisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devis")
public class DevisController {




    private final DevisService devisService;

    @Autowired
    public DevisController(DevisService devisService) {
        this.devisService = devisService;
    }

    // Create a new contact
    @PostMapping
    public ResponseEntity<Devis> createDevis(@RequestBody Devis devis) {
        Devis savedDevis = devisService.createDevis(devis);
        return ResponseEntity.ok(savedDevis);
    }

    // Get all contacts
    @GetMapping
    public List<Devis> getAllContacts() {
        return devisService.getAllDevis();
    }

    // Get a single contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Devis> getDevisById(@PathVariable Long id) {
        return devisService.getDevisById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a contact
    @PutMapping("/{id}")
    public ResponseEntity<Devis> updateDevis(@PathVariable Long id, @RequestBody Devis devis) {
        return devisService.updateDevis(id, devis)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedevis(@PathVariable Long id) {
        if (devisService.deleteDevis(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
