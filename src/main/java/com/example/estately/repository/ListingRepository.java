package com.example.estately.repository;

import com.example.estately.model.Listing;
import com.example.estately.model.ListingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

    Listing findListingByListingName(String name);

    @Query(value = "select * from listing l where listing_name = :name", nativeQuery = true)
    Listing findListingByListingNameWithNativeQuery(String name);
}
