package com.starAndShadow.may.sakila.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    @Query("select a from Customer a where upper(a.fullName) like upper(concat('%', ?1, '%'))")
    List<Customer> findByFullNameContainingIgnoreCase(String name);


}

