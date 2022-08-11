package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
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
	@Autowired
	private FilmRepository filmRepository;

	public FilmController(FilmRepository filmRepository, FilmService filmService) {
		this.filmRepository = filmRepository;
		this.filmService = filmService;
	}

	@GetMapping
	public ResponseEntity<List<FilmDTO>> getAllFilms() {
		return ResponseEntity.ok(filmService.getAllFilms());
	}


	@PostMapping
	public @ResponseBody ResponseEntity<FilmDTO> addFilm(@RequestBody FilmDTO filmDTO ) {
		filmService.saveFilm(filmDTO);
		return new ResponseEntity<FilmDTO>(HttpStatus.CREATED);
	}

	@GetMapping("/search")
	public List<FilmDTO> searchByTitle(@RequestParam String title) { return filmService.getFilmsByTitle(title); }

	@GetMapping("{id}")
	public FilmDTO searchById(@PathVariable Integer id) {
		return filmService.getFilmById(id);
	}

	@PutMapping("{id}")
	public @ResponseBody
	Film updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Film film = filmRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id."));
		film.update(changes);
		return filmRepository.save(film);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteFilmById(@PathVariable Integer id){
		filmRepository.deleteById(id);
	}


}
