package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.exception.ResourceNotFoundException;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.model.Film;
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
	public ResponseEntity<List<FilmDTO>> getAllFilms() {
		return ResponseEntity.ok(filmService.getAllFilms());
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Film> addFilm(@RequestBody FilmDTO filmDTO ) {
		Film film = filmService.saveFilm(filmDTO);
		return new ResponseEntity<Film>(film, HttpStatus.CREATED);
	}

	@GetMapping("/search/title")
	public ResponseEntity<List<FilmDTO>> searchByTitle(@RequestParam String title) {
		List<FilmDTO> filmDTOList = filmService.getFilmsByTitle(title);
		return new ResponseEntity<List<FilmDTO>>(filmDTOList, HttpStatus.OK);
	}

	@GetMapping("/search/category")
	public ResponseEntity<List<FilmDTO>> searchByCategory(@RequestParam String category) {
		List<FilmDTO> filmDTOList = filmService.getFilmsByCategory(category);
		return new ResponseEntity<List<FilmDTO>>(filmDTOList, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<FilmDTO> searchById(@PathVariable Integer id) {
		FilmDTO filmDTOList = filmService.getFilmById(id);
		return new ResponseEntity<FilmDTO>(filmDTOList, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public @ResponseBody
	ResponseEntity<FilmDTO> updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		FilmDTO filmDTO = filmService.updateFilmById(id, changes);
		return new ResponseEntity<FilmDTO>(filmDTO, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<String> deleteFilmById(@PathVariable Integer id){
		filmService.deleteFilmById(id);
		String message = "Item deleted!";
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
}
