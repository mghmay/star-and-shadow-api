package com.starAndShadow.may.sakila.controller;

import com.starAndShadow.may.sakila.dto.FilmDTO;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public Iterable<FilmDTO> getAllFilmsFilterable(@RequestParam(required = false) String title,
												   @RequestParam(required = false) String category,
												   @RequestParam(required = false) Boolean in_stock) {
//		Iterable<Film> filteredFilms;
//		if (title != null) {
//			filteredFilms = filmRepository.findByTitleContainingIgnoreCase(title);
//		}
//		if (category != null) {
//
//		}
		return filmService.getAllFilms();

	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Film addFilm(@RequestBody Film film ) { // title, description, languageId, rentalDuration, rentalRate, replacementCost,
		LocalDateTime now = LocalDateTime.now();
		film.setLastUpdate(String.valueOf(now));
		return filmRepository.save(film);
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
