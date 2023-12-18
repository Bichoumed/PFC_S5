package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import java.util.Set;

                @Entity
                @Table(name = "clients")
                public class Client {
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    private Long id;

                    @Column(name = "name")
                    private String name;

                    @Column(name = "tel")
                    private String telephone;

                    @Column(name = "email")
                    private String email;

                    @Column(name = "address")
                    private String address;

                    @Column(name = "status")
                    private String status;

                    @Column(name = "note")
                    private String note;

                    @ManyToMany(mappedBy = "clients")
                    private Set<Contact> contacts;

                    // No-args constructor
                    public Client() {
                    }

                    // All-args constructor
                    public Client(String name, String telephone, String email, String address, String status, String note, Set<Contact> contacts) {
                        this.name = name;
                        this.telephone = telephone;
                        this.email = email;
                        this.address = address;
                        this.status = status;
                        this.note = note;
                        this.contacts = contacts;
                    }

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

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getNote() {
                        return note;
                    }

                    public void setNote(String note) {
                        this.note = note;
                    }

                    public Set<Contact> getContacts() {
                        return contacts;
                    }

                    public void setContacts(Set<Contact> contacts) {
                        this.contacts = contacts;
                    }
                }


