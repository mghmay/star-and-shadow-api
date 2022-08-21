package com.starAndShadow.may.sakila.service.impl;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.dto.RentalDTO;
import com.starAndShadow.may.sakila.model.*;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.repository.RentalRepository;
import com.starAndShadow.may.sakila.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        super();
        this.rentalRepository = rentalRepository;
    }
    public Rental saveRental(RentalDTO rentalDTO) {
        Rental rental = this.convertDTOToEntity(rentalDTO);
        LocalDateTime now = LocalDateTime.now();
        rental.setLastUpdate(String.valueOf(now));
        rental.setRentalDate(String.valueOf(now));
        return rentalRepository.save(rental);
    };

    private Rental convertDTOToEntity(RentalDTO rentalDTO) {  // title, description, languageId, rentalDuration, rentalRate, replacementCost,
        Rental rental = new Rental();
        rental.setInventoryId(rentalDTO.getInventoryId());
        rental.setCustomerId(rentalDTO.getCustomerId());
        rental.setStaffId(rentalDTO.getStaffId());
        return rental;
    }
}
