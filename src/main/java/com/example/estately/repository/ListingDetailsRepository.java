package com.example.estately.repository;

import com.example.estately.model.ListingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingDetailsRepository extends JpaRepository<ListingDetails, Integer> {
}
