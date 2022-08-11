package com.starAndShadow.may.sakila.service;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.model.*;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    public List<FilmDTO> getFilmsByCategory(String category) {
//        return filmRepository.findByFilmCategoryContainingIgnoreCase(category)
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }

    public List<FilmDTO> getFilmsByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public FilmDTO getFilmById(Integer id) {
        if (filmRepository.findById(id).isPresent()) {
            Film film = filmRepository.findById(id).get();
            return this.convertEntityToDto(film);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }

    private FilmDTO convertEntityToDto(Film film) {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setFilmId(film.getFilmId());
        filmDTO.setLength(film.getLength());
        filmDTO.setTitle(film.getTitle());
        filmDTO.setLanguage(film.getLanguage().getName());
        filmDTO.setRentalRate(film.getRentalRate());
        filmDTO.setRentalDuration(film.getRentalDuration());
        filmDTO.setRating(film.getRating());
        filmDTO.setReleaseYear(film.getReleaseYear());
        filmDTO.setDescription(film.getDescription());
        filmDTO.setLength(film.getLength());
        filmDTO.setSpecialFeatures(film.getSpecialFeatures());
        filmDTO.setCast(film.getActors()
                .stream()
                .map(Actor::getFullName)
                .toList());
        filmDTO.setInventory(film.getInventory()
                .stream()
                .map(Inventory::getStoreId)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())));
        filmDTO.setCategory(String.valueOf(film.getFilmCategory()
                .stream()
                .map(Category::getName)
                .toList()));
        return filmDTO;
    }
}
