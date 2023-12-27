package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.Task;
import com.mizanlabs.mr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task taskDetails) {
        try {
            return taskRepository.findById(id).map(task -> {
                task.setTaskName(taskDetails.getTaskName());
                task.setTaskStart(taskDetails.getTaskStart());
                task.setTaskDeadline(taskDetails.getTaskDeadline());
                task.setTaskPriority(taskDetails.getTaskPriority());
                task.setTaskStatus(taskDetails.getTaskStatus());
                task.setTaskNote(taskDetails.getTaskNote());
                return taskRepository.save(task);
            });
        } catch (Exception e) {
            // Gérer l'exception (par exemple, journalisation)
            e.printStackTrace();
            return Optional.empty();
        }
    }


    public boolean deleteTask(Long id) {
        boolean exists = taskRepository.existsById(id);
        if (!exists) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }
}
