package com.mizanlabs.mr.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "devis_projects")
public class DevisProjects {



	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "devis_id")
	    private Devis devis;

	    @ManyToOne
	    @JoinColumn(name = "project_id")
	    private Projects projects;

		public DevisProjects() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DevisProjects(Long id, Devis devis, Projects projects) {
			super();
			this.id = id;
			this.devis = devis;
			this.projects = projects;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Devis getDevis() {
			return devis;
		}

		public void setDevis(Devis devis) {
			this.devis = devis;
		}

		public Projects getProjects() {
			return projects;
		}

		public void setProjects(Projects projects) {
			this.projects = projects;
		}

	 
}
