package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.exception.ResourceNotFoundException;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.response.ResponseHandler;
import com.starAndShadow.may.sakila.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/films")
public class FilmController {
	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping
	public ResponseEntity<Object> getAllFilms() {
		try {
			List<FilmDTO> result = filmService.getAllFilms();
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> addFilm(@RequestBody FilmDTO filmDTO ) {
		try {
			Film result = filmService.saveFilm(filmDTO);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("/search/title")
	public ResponseEntity<Object> searchByTitle(@RequestParam String title) {
		try {
			List<FilmDTO> result = filmService.getFilmsByTitle(title);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("/search/category")
	public ResponseEntity<Object> searchByCategory(@RequestParam String category) {
		try {
			List<FilmDTO> result = filmService.getFilmsByCategory(category);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> searchById(@PathVariable Integer id) {
		try {
			FilmDTO result = filmService.getFilmById(id);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PutMapping("{id}")
	public @ResponseBody
	ResponseEntity<Object> updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		try {
			FilmDTO result = filmService.updateFilmById(id, changes);
			return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<Object> deleteFilmById(@PathVariable Integer id){
		try {
			filmService.deleteFilmById(id);
			return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
}
