package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Category;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.FilmCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query("select f from Film f where upper(f.title) like upper(concat('%', ?1, '%'))")
    List<Film> findByTitleContainingIgnoreCase(String title);

//    @Query("select f from Film f where upper(f.filmCategory) like upper(concat('%', :filmCategory, '%'))")
//    List<Film> findByFilmCategoryContainingIgnoreCase(@Param("filmCategory") String category);

    @Override
    List<Film> findAll();

}

