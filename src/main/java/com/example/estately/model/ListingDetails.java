package com.example.estately.model;

import javax.persistence.*;

@Entity
@Table(name = "listing_details")
public class ListingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingDetailsId;

    private String description;

    public ListingDetails() {
    }

    public ListingDetails(String description) {
        this.description = description;
    }

    public int getListingDetailsId() {
        return listingDetailsId;
    }

    public void setListingDetailsId(int listingDetailsId) {
        this.listingDetailsId = listingDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
