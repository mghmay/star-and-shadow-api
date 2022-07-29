package com.starAndShadow.may.sakila.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

    @Query("select c from Category c where upper(c.name) like upper(concat('%', ?1, '%'))")
    List<Category> findByNameContainingIgnoreCase(String name);

}

