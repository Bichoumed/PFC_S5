package com.mizanlabs.mr.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "devis")
public class Devis {



	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long devisId;

	    
	    @Temporal(TemporalType.DATE)
	    @Column(name = "devis_date")
	    private Date devis_date;

	    @Column(name = "devis_amount")
	    private int devis_amount;
	    

	    @Column(name = "devis_discount")
	    private int devis_discount;
	    
	    

	    @Column(name = "devis_status")
	    private String devis_status;
	    

	    @Column(name = "devis_note")
	    private int devis_note;
	    
	    
	    @ManyToMany
	    @JoinTable(
	            name = "devis_projects", // Nom de la table de jointure
	            joinColumns = @JoinColumn(name = "devis_id"),
	            inverseJoinColumns = @JoinColumn(name = "project_id")
	            
	    )
	    @JsonIgnoreProperties("devis")
	    private Set<Projects> projects;


		public Devis(Long devisId, Date devis_date, int devis_amount, int devis_discount, String devis_status,
				int devis_note, Set<com.mizanlabs.mr.entities.Projects> projects) {
			super();
			this.devisId = devisId;
			this.devis_date = devis_date;
			this.devis_amount = devis_amount;
			this.devis_discount = devis_discount;
			this.devis_status = devis_status;
			this.devis_note = devis_note;
			this.projects = projects;
		}


		public Devis() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Long getDevisId() {
			return devisId;
		}


		public void setDevisId(Long devisId) {
			this.devisId = devisId;
		}


		public Date getDevis_date() {
			return devis_date;
		}


		public void setDevis_date(Date devis_date) {
			this.devis_date = devis_date;
		}


		public int getDevis_amount() {
			return devis_amount;
		}


		public void setDevis_amount(int devis_amount) {
			this.devis_amount = devis_amount;
		}


		public int getDevis_discount() {
			return devis_discount;
		}


		public void setDevis_discount(int devis_discount) {
			this.devis_discount = devis_discount;
		}


		public String getDevis_status() {
			return devis_status;
		}


		public void setDevis_status(String devis_status) {
			this.devis_status = devis_status;
		}


		public int getDevis_note() {
			return devis_note;
		}


		public void setDevis_note(int devis_note) {
			this.devis_note = devis_note;
		}


		public Set<Projects> getProjects() {
			return projects;
		}


		public void setProjects(Set<Projects> projects) {
			this.projects = projects;
		}


}
