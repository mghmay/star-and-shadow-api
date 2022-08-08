package com.starAndShadow.may.sakila.staff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff,Integer> {

    @Query("select a from Customer a where upper(a.fullName) like upper(concat('%', ?1, '%'))")
    List<Staff> findByFullNameContainingIgnoreCase(String name);


}

