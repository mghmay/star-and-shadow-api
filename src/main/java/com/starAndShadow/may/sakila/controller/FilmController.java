package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.exception.ResourceNotFoundException;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.response.ResponseHandler;
import com.starAndShadow.may.sakila.service.FilmService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/films")
@AllArgsConstructor
@NoArgsConstructor
public class FilmController {
	@Autowired
	private FilmService filmService;

	@GetMapping
	public ResponseEntity<Object> getAllFilms(@RequestParam(defaultValue = "0") Integer pageNo,
											  @RequestParam(defaultValue = "") String title,
											  @RequestParam(defaultValue = "") String category,
											  @RequestParam(defaultValue = "20") Integer pageSize,
											  @RequestParam(defaultValue = "id") String sortBy) {
		try {
			List<FilmDTO> result = filmService.getAllFilms(category, title, pageNo, pageSize, sortBy);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (ResourceNotFoundException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> addFilm(@RequestBody FilmDTO filmDTO ) {
		try {
			Film result = filmService.saveFilm(filmDTO);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (ResourceNotFoundException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> searchById(@PathVariable Integer id) {
		try {
			FilmDTO result = filmService.getFilmById(id);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (ResourceNotFoundException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping("{id}")
	public @ResponseBody
	ResponseEntity<Object> updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		try {
			FilmDTO result = filmService.updateFilmById(id, changes);
			return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
		} catch (ResourceNotFoundException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<Object> deleteFilmById(@PathVariable Integer id){
		try {
			filmService.deleteFilmById(id);
			return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, null);
		} catch (ResourceNotFoundException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}
