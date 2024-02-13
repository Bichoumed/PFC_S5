package com.mizanlabs.mr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mizanlabs.mr.entities.ContactsClients;

public interface ContactsClientsRepository extends JpaRepository<ContactsClients, Long> {
    
	@Modifying
	@Query("DELETE FROM ContactsClients  WHERE client.id = :clientId AND contact.id = :contactId")
    void deleteByClientIdAndContactId(Long clientId, Long contactId);
}
