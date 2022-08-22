package com.starAndShadow.may.sakila.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.exception.ResourceNotFoundException;
import com.starAndShadow.may.sakila.model.Actor;
import com.starAndShadow.may.sakila.model.Category;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Inventory;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.service.FilmService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
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
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<FilmDTO> getFilmsByCategory(String category) {
        return filmRepository.findByFilmCategoryNameContainingIgnoreCase(category)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<FilmDTO> getFilmsByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    public FilmDTO getFilmById(Integer id) {
        if (filmRepository.findById(id).isPresent()) {
            Film film = filmRepository.findById(id).get();
            return this.convertEntityToDTO(film);
        } else {
            throw new ResourceNotFoundException("Not found", "Unable to find film by id", id);
        }
    }
    public FilmDTO updateFilmById(Integer id, Map changes) {
        if (filmRepository.findById(id).isPresent()) {
            Film film = filmRepository.findById(id).get();
            this.update(film, changes);
            filmRepository.save(film);
            return this.convertEntityToDTO(film);
        } else {
            throw new ResourceNotFoundException("Not found", "Unable to find film by id", id);
        }
    }
    public void deleteFilmById(Integer id) {
        if (filmRepository.findById(id).isPresent()) {
            filmRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Not found", "Unable to find film by id", id);
        }
    }
    public Film saveFilm(FilmDTO filmDTO) {
        Film film = this.convertDTOToEntity(filmDTO);
        LocalDateTime now = LocalDateTime.now();
        film.setLastUpdate(String.valueOf(now));
        return filmRepository.save(film);
    };
    private FilmDTO convertEntityToDTO(Film film) {
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
        if (film.getSpecialFeatures() != null) {
            String[] features = film.getSpecialFeatures().split(",");
            filmDTO.setSpecialFeatures(features);
        } else {
            filmDTO.setSpecialFeatures(new String[0]);
        }
        filmDTO.setCast(film.getActors()
                .stream()
                .map(Actor::getFullName)
                .toList());
        HashMap<String, List<Integer>> addressInventory = new HashMap<>();
        film.getInventory()
                .forEach((Inventory inventory) -> {
                    String address = inventory.getStore().getAddress().getAddress();
                    int id = inventory.getInventoryId();
                    if (addressInventory.containsKey(address)) {
                        addressInventory.get(address).add(id);
                    } else {
                        addressInventory.put(address, new ArrayList<>(List.of(id)));
                    }
                });
        filmDTO.setInventory(addressInventory);
        filmDTO.setCategory(film.getFilmCategory()
                .stream()
                .map(Category::getName)
                .toList());
        return filmDTO;
    }
    private Film convertDTOToEntity(FilmDTO filmDTO) {  // title, description, languageId, rentalDuration, rentalRate, replacementCost,
        Film film = new Film();
        film.setTitle(filmDTO.getTitle());
        film.setDescription(filmDTO.getDescription());
        film.setLanguageId(filmDTO.getLanguageId());
        film.setRentalDuration(filmDTO.getRentalDuration());
        film.setRentalRate(filmDTO.getRentalRate());
        film.setReplacementCost(filmDTO.getReplacementCost());

        return film;
    }

    private void update(Film film, Map<String, Object> changes) {
        changes.forEach(
            (change, value) -> {
                switch (change) {
                    case "title":
                        film.setTitle((String) value);
                        break;
                    case "description":
                        film.setDescription((String) value);
                        break;
                    case "releaseYear":
                        film.setReleaseYear((Integer) value);
                        break;
                    case "languageId":
                        film.setLanguageId((Integer) value);
                        break;
                    case "originalLanguageId":
                        film.setOriginalLanguageId((Integer) value);
                        break;
                    case "rentalDuration":
                        film.setRentalDuration((Integer) value);
                        break;
                    case "rentalRate":
                        film.setRentalRate((BigDecimal) value);
                        break;
                    case "length":
                        film.setLength((Integer) value);
                        break;
                    case "replacementCost":
                        film.setReplacementCost((BigDecimal) value);
                        break;
                    case "rating":
                        film.setRating((String) value);
                        break;
                    case "specialFeatures":
                        film.setSpecialFeatures((String) value);
                        break;
                }
            }
        );
        LocalDateTime now = LocalDateTime.now();
        film.setLastUpdate(String.valueOf(now));
    }
}
