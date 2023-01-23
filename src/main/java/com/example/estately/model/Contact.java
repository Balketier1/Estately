package com.example.estately.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContact;

    @NotBlank(message = "Phone number cannot be null!")
    @Pattern(regexp = "(\\+4|0)[0-9]{9}")
    private String phone_number;


    @NotBlank(message =  "City cannot be empty")
    private String city;
    @NotBlank(message =  "Street cannot be empty")
    private String street;
    @NotNull(message =  "Street No. cannot be empty")
    private int streetNumber;

    @OneToOne(mappedBy = "contact")
    @JsonIgnore
    private Agent agent;


    public Contact() {
    }


    public Contact(String phone_number, String city, String street, int streetNumber) {

        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
    public Contact(String phone_number, String city, String street, int streetNumber, Agent agent) {

        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.agent = agent;
    }
    public int getIdContact() {
        return idContact;
    }

    public void setIdContac(int idContact) {
        this.idContact = idContact;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "idContact=" + idContact +
                ", phone_number='" + phone_number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
