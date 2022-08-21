package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.dto.RentalDTO;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Rental;
import com.starAndShadow.may.sakila.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/rental")
public class RentalController {
    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Rental> addRental(@RequestBody RentalDTO rentalDTO ) {
        Rental rental = rentalService.saveRental(rentalDTO);
        return new ResponseEntity<Rental>(rental, HttpStatus.CREATED);
    }
}
