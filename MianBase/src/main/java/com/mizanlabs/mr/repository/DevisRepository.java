package com.mizanlabs.mr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mizanlabs.mr.entities.Devis;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {
}
