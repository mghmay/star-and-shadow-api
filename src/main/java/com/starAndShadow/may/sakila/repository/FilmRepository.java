package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query("select f from Film f where upper(f.title) like upper(concat('%', ?1, '%'))")
    List<Film> findByTitleContainingIgnoreCase(String title);
}

