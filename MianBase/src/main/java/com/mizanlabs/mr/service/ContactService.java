package com.mizanlabs.mr.service;

import com.mizanlabs.mr.repository.ContactRepository;
import com.mizanlabs.mr.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Renamed from findAllContacts to match the controller
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Renamed from findContactById to match the controller
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    // Renamed from saveContact to match the controller
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Renamed from updateContact and changed return type to Optional<Contact> to match the controller
    public Optional<Contact> updateContact(Long id, Contact contactDetails) {
        return contactRepository.findById(id).map(contact -> {
            contact.setName(contactDetails.getName());
            contact.setEmail(contactDetails.getEmail());
            // Set other fields...
            return contactRepository.save(contact);
        });
    }

    // Changed to return a boolean to match the controller's expectation
    public boolean deleteContact(Long id) {
        boolean exists = contactRepository.existsById(id);
        if (!exists) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }
}
