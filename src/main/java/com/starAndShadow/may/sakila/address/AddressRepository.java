package com.starAndShadow.may.sakila.address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Integer> {
    @Query("select a from Address a where upper(a.address) like upper(concat('%', ?1, '%'))")
    List<Address> findByAddressContainingIgnoreCase(String name);

}

