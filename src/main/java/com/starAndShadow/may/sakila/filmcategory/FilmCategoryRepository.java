package com.starAndShadow.may.sakila.filmcategory;


import org.springframework.data.repository.CrudRepository;
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
}