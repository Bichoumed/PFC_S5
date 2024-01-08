package com.mizanlabs.mr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mizanlabs.mr.entities.Projects;

@Repository

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    // Additional methods, if necessary, can be defined here
}