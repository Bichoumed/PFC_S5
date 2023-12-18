package com.mizanlabs.mr.repository;

import com.mizanlabs.mr.entities.ContactsClientsId;
import com.mizanlabs.mr.entities.ContactsClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsClientsRepository extends JpaRepository<ContactsClients, ContactsClientsId> {
    // Additional methods, if necessary, can be defined here
}