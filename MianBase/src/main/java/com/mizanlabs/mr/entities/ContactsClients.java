package com.mizanlabs.mr.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "contacts_clients")
public class ContactsClients {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
    @ManyToOne
    @MapsId("contactId")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "is_principal")
    private Boolean isPrincipal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(Boolean isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public ContactsClients(Long id, Contact contact, Client client, Boolean isPrincipal) {
		super();
		this.id = id;
		this.contact = contact;
		this.client = client;
		this.isPrincipal = isPrincipal;
	}

	public ContactsClients() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
