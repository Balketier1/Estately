package com.example.estately;

import com.example.estately.model.Listing;
import com.example.estately.model.ListingDetails;
import com.example.estately.model.Seller;
import com.example.estately.model.Zone;
import com.example.estately.repository.ListingDetailsRepository;
import com.example.estately.repository.ListingRepository;
import com.example.estately.repository.ZoneRepository;
import com.example.estately.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EstatelyApplication implements CommandLineRunner {

	@Autowired
	private ListingRepository listingRepository;
	@Autowired
	private ListingDetailsRepository listingDetailsRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ZoneRepository zoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstatelyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Seller seller1 = new Seller("Seller1");
		Seller seller2 = new Seller("Seller2");

		sellerRepository.save(seller1);
		sellerRepository.save(seller2);

		ListingDetails listingDetails1 = new ListingDetails("Description LISTING 1");
		ListingDetails listingDetails2 = new ListingDetails("Description LISTING 2");

		listingDetailsRepository.save(listingDetails1);
		listingDetailsRepository.save(listingDetails2);

		Listing listing1 = new Listing("Listing1", 5000);
		Listing listing2 = new Listing("Listing2", 25000);

		listing1.setListingDetails(listingDetails1);
		listing2.setListingDetails(listingDetails2);

		listing1.setSeller(seller1);
		listing2.setSeller(seller2);

		listingRepository.save(listing1);
		listingRepository.save(listing2);

		Zone zone = new Zone("Bucuresti Sector 6");

		zone.setListingList(List.of(listing1, listing2));
		zoneRepository.save(zone);

	}
}
