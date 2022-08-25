package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental,Integer> {

    @Override
    List<Rental> findAll();
}
