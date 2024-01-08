package com.mizanlabs.mr.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "projects")
public class Projects {

	                    @Id
	                    @GeneratedValue(strategy = GenerationType.IDENTITY)
	                    private Long projectId;

	                    @Column(name = "name")
	                    private String name;

	                    @Column(name = "titre")
	                    private String titre;

	                    @Column(name = "project_MO")
	                    private String project_MO;

	                    @Column(name = "project_MOE")
	                    private String project_MOE;

	                    @Column(name = "project_bct")
	                    private String project_bct;

	                    @Column(name = "project_localistion")
	                    private String project_localistion;
	                    
	                    @Temporal(TemporalType.DATE)
	                    @Column(name = "date_de_creation")
	                    private Date date_de_creation;


	                    @ManyToMany(mappedBy = "projects")
	                    @JsonIgnoreProperties("projects")
	                    private Set<Devis> devis;

	                    
	                    @ManyToMany(mappedBy = "projects")
	                    @JsonIgnoreProperties("projects")

	                    private Set<Task> tasks;

						public Projects(Long projectId, String name, String titre, String project_MO,
								String project_MOE, String project_bct, String project_localistion,
								Date date_de_creation, Set<com.mizanlabs.mr.entities.Devis> devis,Set<com.mizanlabs.mr.entities.Task> tasks) {
							super();
							this.projectId = projectId;
							this.name = name;
							this.titre = titre;
							this.project_MO = project_MO;
							this.project_MOE = project_MOE;
							this.project_bct = project_bct;
							this.project_localistion = project_localistion;
							this.date_de_creation = date_de_creation;
							this.devis = devis;
							this.tasks = tasks;

						}


						public Projects() {
							super();
							// TODO Auto-generated constructor stub
						}


						public Long getProjectId() {
							return projectId;
						}


						public void setProjectId(Long projectId) {
							this.projectId = projectId;
						}


						public String getName() {
							return name;
						}


						public void setName(String name) {
							this.name = name;
						}


						public String getTitre() {
							return titre;
						}


						public void setTitre(String titre) {
							this.titre = titre;
						}


						public String getProject_MO() {
							return project_MO;
						}


						public void setProject_MO(String project_MO) {
							this.project_MO = project_MO;
						}


						public String getProject_MOE() {
							return project_MOE;
						}


						public void setProject_MOE(String project_MOE) {
							this.project_MOE = project_MOE;
						}


						public String getProject_bct() {
							return project_bct;
						}


						public void setProject_bct(String project_bct) {
							this.project_bct = project_bct;
						}
						
						public String getProject_localistion() {
							return project_localistion;
						}


						public void setProject_localistion(String project_localistion) {
							this.project_localistion = project_localistion;
						}


						public Date getDate_de_creation() {
							return date_de_creation;
						}


						public void setDate_de_creation(Date date_de_creation) {
							this.date_de_creation = date_de_creation;
						}


						public Set<Devis> getDevis() {
							return devis;
						}


						public void setDevis(Set<Devis> devis) {
							this.devis = devis;
						}
						
						public Set<Task> getTasks() {
							return tasks;
						}


						public void setTasks(Set<Task> tasks) {
							this.tasks = tasks;
						}
	                    

}
