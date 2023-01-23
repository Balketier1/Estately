package com.example.estately.service;

import com.example.estately.model.Listing;
import com.example.estately.model.ListingDetails;
import com.example.estately.model.Seller;
import com.example.estately.model.Zone;
import com.example.estately.repository.ListingDetailsRepository;
import com.example.estately.repository.ListingRepository;
import com.example.estately.repository.ZoneRepository;
import com.example.estately.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    private ListingRepository listingRepository;
    private ListingDetailsRepository listingDetailsRepository;
    private SellerRepository sellerRepository;
    private ZoneRepository zoneRepository;

    public MarketService(ListingRepository listingRepository, ListingDetailsRepository listingDetailsRepository, SellerRepository sellerRepository, ZoneRepository zoneRepository) {
        this.listingRepository = listingRepository;
        this.listingDetailsRepository = listingDetailsRepository;
        this.sellerRepository = sellerRepository;
        this.zoneRepository = zoneRepository;
    }

    public Seller saveNewSeller(Seller seller){
        return sellerRepository.save(seller);
    }

    public ListingDetails saveNewListingDetails(ListingDetails listingDetails) {
        return listingDetailsRepository.save(listingDetails);
    }

    public Listing saveNewListing(Listing listing, int listingDetailsId, int sellerId) {
        ListingDetails listingDetails = listingDetailsRepository.findById(listingDetailsId).orElseThrow(
                () -> new RuntimeException("Listing with this description NOT FOUND"));

        Seller seller = sellerRepository.findById(sellerId).orElseThrow(
                () -> new RuntimeException("Seller with this id NOT FOUND"));

        listing.setSeller(seller);
        listing.setListingDetails(listingDetails);

        return listingRepository.save(listing);
    }

    public Zone saveZone(Zone zone, List<Integer> listingIds) {
        List<Listing> listingList = listingRepository.findAllById(listingIds);
        zone.setListingList(listingList);

        return zoneRepository.save(zone);
    }

    public List<Zone> retrieveZones() {
        return zoneRepository.findAll();
    }

    public Listing retrieveListingByName(String listingName) {
        return listingRepository.findListingByListingNameWithNativeQuery(listingName);
    }

    public String bulkLoadSeller(int n) {
        for(int i = 10; i < n; i++){
            Seller seller = new Seller("Seller" + i);
            sellerRepository.save(seller);
        }
        return "Seller bulkLoad Done!";
    }

}
