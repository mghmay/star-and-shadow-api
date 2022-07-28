package com.starAndShadow.may.sakila.actor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    @Query("select a from Actor a where upper(a.fullName) like upper(concat('%', ?1, '%'))")
    List<Actor> findByFullNameContainingIgnoreCase(String name);


}

