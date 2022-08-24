package com.starAndShadow.may.sakila.repository;

import com.starAndShadow.may.sakila.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import org.springframework.data.domain.Pageable;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    @Query("""
            select f from Film f inner join f.category filmCategory
            where upper(filmCategory.name) like upper(concat('%', ?1, '%')) and upper(f.title) like upper(concat('%', ?2, '%'))""")
    Page<Film> findByTitleAndFilmCategoryNameContainingIgnoreCase(String category, String title, Pageable paging);

}

