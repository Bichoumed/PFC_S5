package com.mizanlabs.mr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mizanlabs.mr.entities.Client; // Replace with your actual package and class names

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Additional methods, if necessary, can be defined here
}