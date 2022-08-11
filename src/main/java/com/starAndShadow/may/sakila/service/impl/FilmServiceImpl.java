package com.starAndShadow.may.sakila.service.impl;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.exception.ResourceNotFoundException;
import com.starAndShadow.may.sakila.model.Actor;
import com.starAndShadow.may.sakila.model.Category;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Inventory;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        super();
        this.filmRepository = filmRepository;
    }

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
            throw new ResourceNotFoundException("Not found", "Unable to find resource", id);
        }
    }

    public Film saveFilm(FilmDTO filmDTO) {
        Film film = this.convertDtoToEntity(filmDTO);
        LocalDateTime now = LocalDateTime.now();
        film.setLastUpdate(String.valueOf(now));
        return filmRepository.save(film);
    };

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
    private Film convertDtoToEntity(FilmDTO filmDTO) {  // title, description, languageId, rentalDuration, rentalRate, replacementCost,
        Film film = new Film();
        film.setTitle(filmDTO.getTitle());
        film.setDescription(filmDTO.getDescription());
        film.setLanguageId(filmDTO.getLanguageId());
        film.setRentalDuration(filmDTO.getRentalDuration());
        film.setRentalRate(filmDTO.getRentalRate());
        film.setReplacementCost(filmDTO.getReplacementCost());

        return film;
    }
}
