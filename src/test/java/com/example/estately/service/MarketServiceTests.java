package com.example.estately.service;

import com.example.estately.model.Seller;
import com.example.estately.repository.ListingDetailsRepository;
import com.example.estately.repository.ListingRepository;
import com.example.estately.repository.SellerRepository;
import com.example.estately.repository.ZoneRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.Table;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MarketServiceTests {

    @InjectMocks
    private MarketService marketService;

    @Mock
    private ListingRepository listingRepository;
    @Mock
    private ListingDetailsRepository listingDetailsRepository;
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private ZoneRepository zoneRepository;

    @Test
    @DisplayName("Running save seller in happy flow")
    void saveNewSellerHappyFlow() {
        Seller seller = new Seller("Seller Test1");
        when(sellerRepository.save(seller)).thenReturn(seller);

        Seller result = marketService.saveNewSeller(seller);

        assertEquals(seller.getSellerName(), result.getSellerName());
    }
}
