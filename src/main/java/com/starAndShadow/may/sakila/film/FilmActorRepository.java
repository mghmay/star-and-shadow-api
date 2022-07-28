package com.starAndShadow.may.sakila.film;

import org.springframework.data.repository.CrudRepository;
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {
}