package com.starAndShadow.may.sakila.service;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {
    List<FilmDTO> getAllFilms();
    List<FilmDTO> getFilmsByTitle(String title);
    FilmDTO getFilmById(Integer id);

    Film saveFilm(FilmDTO film);
}
