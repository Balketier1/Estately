package com.example.estately.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingId;

    private String listingName;
    private int ListingPrice;

    @OneToOne
    @JoinColumn(name = "listing_details_id") // => Numele coloanei de legatura dintre cele 2 tabele
    private ListingDetails listingDetails;

    @ManyToOne
    @JoinColumn(name = "seller_id") // Ii dau cheia - coloana pt foreign key-ul seller-ului in tabela de listing
    private Seller seller;

    @ManyToMany(mappedBy = "listingList")
    @JsonIgnore
    private List<Zone> zones = new ArrayList<>();

    public Listing() {
    }

    public Listing(String listingName, int listingPrice) {
        this.listingName = listingName;
        ListingPrice = listingPrice;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public int getListingPrice() {
        return ListingPrice;
    }

    public void setListingPrice(int listingPrice) {
        ListingPrice = listingPrice;
    }

    public ListingDetails getListingDetails() {
        return listingDetails;
    }

    public void setListingDetails(ListingDetails listingDetails) {
        this.listingDetails = listingDetails;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

}
