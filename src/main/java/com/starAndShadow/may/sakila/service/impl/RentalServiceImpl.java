package com.starAndShadow.may.sakila.service.impl;

import com.starAndShadow.may.sakila.dto.RentalDTO;
import com.starAndShadow.may.sakila.model.Rental;
import com.starAndShadow.may.sakila.repository.RentalRepository;
import com.starAndShadow.may.sakila.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .toList();
    }

    public Rental saveRental(RentalDTO rentalDTO) {
        Rental rental = this.convertDTOToEntity(rentalDTO);
        LocalDateTime now = LocalDateTime.now();
        rental.setLastUpdate(String.valueOf(now));
        rental.setRentalDate(String.valueOf(now));
        return rentalRepository.save(rental);
    }

    private Rental convertDTOToEntity(RentalDTO rentalDTO) {  // title, description, languageId, rentalDuration, rentalRate, replacementCost,
        Rental rental = new Rental();
        rental.setInventoryId(rentalDTO.getInventoryId());
        rental.setCustomerId(rentalDTO.getCustomerId());
        rental.setStaffId(rentalDTO.getStaffId());
        return rental;
    }

    private RentalDTO convertEntityToDTO(Rental rental) {  // title, description, languageId, rentalDuration, rentalRate, replacementCost,
        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalDate(rental.getRentalDate());
        rentalDTO.setInventoryId(rental.getInventoryId());
        rentalDTO.setCustomerId(rental.getCustomerId());
        rentalDTO.setStaffId(rental.getStaffId());
        return rentalDTO;
    }
}
