package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Category;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.FilmCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query("select f from Film f where upper(f.title) like upper(concat('%', ?1, '%'))")
    List<Film> findByTitleContainingIgnoreCase(String title);

    @Query(value = "SELECT title, name AS category_name FROM film INNER JOIN film_category ON film.film_id = film_category.film_id INNER JOIN category ON film_category.category_id = category.category_id WHERE name LIKE ?1", nativeQuery = true)
    List<Film> findFilmByCategory(String category);


    @Override
    List<Film> findAll();
}

