package com.mizanlabs.mr.repository;

import com.mizanlabs.mr.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
