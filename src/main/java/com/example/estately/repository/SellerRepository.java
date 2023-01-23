package com.example.estately.repository;

import com.example.estately.model.Listing;
import com.example.estately.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository  extends JpaRepository<Seller, Integer> {
}
