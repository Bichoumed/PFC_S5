package com.mizanlabs.mr.controller;
import com.mizanlabs.mr.entities.Projects;
import com.mizanlabs.mr.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {
    private final ProjectsService projectsService ;
    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }
    
    @PostMapping
    public ResponseEntity<Projects> createProjects(@RequestBody Projects projects) {
    	Projects savedProjects = projectsService.createProjects(projects);
        return ResponseEntity.ok(savedProjects);
    }
    
    @GetMapping
    public List<Projects> getAllProjects() {
        return projectsService.getAllprojects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Projects> getProjectsById(@PathVariable Long id) {
        return projectsService.getProjectsById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Projects> updateProjects(@PathVariable Long id, @RequestBody Projects projects) {
        return projectsService.updateProjects(id, projects)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (projectsService.deleteClient(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


