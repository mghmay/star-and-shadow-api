package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental,Integer> {
}
