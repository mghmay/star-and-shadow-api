package com.starAndShadow.may.sakila.repository;


import com.starAndShadow.may.sakila.model.FilmCategory;
import org.springframework.data.repository.CrudRepository;
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
}