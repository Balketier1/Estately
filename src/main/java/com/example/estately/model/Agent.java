package com.example.estately.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgent;

    @NotBlank(message =  "Name cannot be empty")
    @Column(unique = true)
    private String name;


    @OneToOne
    @JoinColumn(name = "idContact")
    private Contact contact;

    @OneToMany
    @JsonIgnore
    private List<Listing> listings;

    public Agent(String name, Contact contact){
        this.name = name;
        this.contact = contact;
    }
    public Agent(int id, String name){

        this.name = name;
        this.idAgent = id;
    }
    public Agent() {
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name2) {
        name = name2;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "idAgent=" + idAgent +
                ", Nume='" + name + '\'' +
                ", contact=" + contact +
                ", listings=" + listings +
                '}';
    }
}
