package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.Projects;
import com.mizanlabs.mr.repository.ProjectsRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {




    private final ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public List<Projects> getAllprojects() {
        return projectsRepository.findAll();
    }

    public Optional<Projects> getProjectsById(Long id) {
        return projectsRepository.findById(id);
    }

   public  Projects createProjects(Projects projects) {
        return projectsRepository.save(projects);
    }
    public Optional<Projects> updateProjects(Long id, Projects projectsDetails) {
        return projectsRepository.findById(id).map(projects -> {
        	projects.setDate_de_creation(projectsDetails.getDate_de_creation());
        	projects.setProject_localistion(projectsDetails.getProject_localistion());
        	projects.setProject_bct(projectsDetails.getProject_bct());
        	projects.setProject_MOE(projectsDetails.getProject_MOE());
        	projects.setProject_MO(projectsDetails.getProject_MO());
        	projects.setProject_MO(projectsDetails.getProject_MO());
        	projects.setDevis(projectsDetails.getDevis());

            return projectsRepository.save(projects);
        });
    }
    
    public boolean deleteClient(Long id) {
        boolean exists = projectsRepository.existsById(id);
        if (!exists) {
            return false;
        }
        projectsRepository.deleteById(id);
        return true;
    }

	public static List<com.mizanlabs.mr.entities.Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}
}
