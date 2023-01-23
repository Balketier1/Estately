package com.example.estately.controller;

import com.example.estately.model.Listing;
import com.example.estately.model.ListingDetails;
import com.example.estately.model.Seller;
import com.example.estately.model.Zone;
import com.example.estately.service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/seller")
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
        return ResponseEntity.ok().body(marketService.saveNewSeller(seller));
    }

    @PostMapping("/listingDetails")
    public ResponseEntity<ListingDetails> saveListingDetails(@RequestBody ListingDetails listingDetails){
        return ResponseEntity.ok().body(marketService.saveNewListingDetails(listingDetails));
    }

    @PostMapping("/listing")
    public ResponseEntity<Listing> saveAlbum(@RequestBody Listing listing,
                                           @RequestParam int listingDetailsId,
                                           @RequestParam int sellerId){
        return ResponseEntity.ok().body(marketService.saveNewListing(listing, listingDetailsId, sellerId));
    }

    @PostMapping
    public ResponseEntity<Zone> saveShop(@RequestBody Zone zone,
                                         @RequestParam List<Integer> listingIds){
        return ResponseEntity.ok().body(marketService.saveZone(zone, listingIds));
    }

    @GetMapping
    public ResponseEntity<List<Zone>> retrieveZone() {
        return ResponseEntity.ok().body(marketService.retrieveZones());
    }

    @GetMapping("/listing")
    public ResponseEntity<Listing> retrieveByName(@RequestParam String listingName){
        return ResponseEntity.ok().body(marketService.retrieveListingByName(listingName));
    }

    //--------ADD PUT DELETE

}
