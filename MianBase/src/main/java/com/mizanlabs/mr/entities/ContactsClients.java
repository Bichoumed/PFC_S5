package com.mizanlabs.mr.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "contacts_clients")
public class ContactsClients {

    @EmbeddedId
    private ContactsClientsId id;

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

}