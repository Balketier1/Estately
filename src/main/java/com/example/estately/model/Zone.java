package com.example.estately.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zoneId;

    private String location;

    @ManyToMany
    @JoinTable(name = "zone_listing", joinColumns = @JoinColumn(name = "zone_id"), inverseJoinColumns = @JoinColumn(name = "listing_id"))
    private List<Listing> listingList = new ArrayList<>();

    public Zone(String location) {
        this.location = location;
    }

    public Zone() {
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Listing> getListingList() {
        return listingList;
    }

    public void setListingList(List<Listing> listingList) {
        this.listingList = listingList;
    }

}
