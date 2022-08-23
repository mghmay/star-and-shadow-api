package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Customer;
import com.starAndShadow.may.sakila.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    @Override
    List<Customer> findAll();
}
