package com.mizanlabs.mr.entities;





import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Contact() {
    }


    public Contact(String name, String telephone, String email, String address, String profession, String note, Set<Client> clients) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.profession = profession;
        this.note = note;
        this.clients = clients;
    }

    @Column(name = "tel")
    private String telephone;


    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "profession")
    private String profession;

    @Column(name = "note")
    private String note;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "contacts_clients",
            joinColumns = { @JoinColumn(name = "contact_id") },
            inverseJoinColumns = { @JoinColumn(name = "client_id") }
    )
    @JsonIgnoreProperties("contacts")
    Set<Client> clients;

}
