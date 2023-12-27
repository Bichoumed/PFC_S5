package com.mizanlabs.mr.repository;

import com.mizanlabs.mr.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
	
}
