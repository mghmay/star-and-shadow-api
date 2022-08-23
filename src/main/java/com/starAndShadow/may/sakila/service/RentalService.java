package com.starAndShadow.may.sakila.service;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.dto.RentalDTO;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalService {
    Rental saveRental(RentalDTO rental);

    List<RentalDTO> getAllRentals();
}
