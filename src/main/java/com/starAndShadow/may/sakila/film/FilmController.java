package com.starAndShadow.may.sakila.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/films")
public class FilmController {
	@Autowired
	private FilmRepository filmRepository;
	public FilmController(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping
	public Iterable<Film>getAllFilms() { return filmRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Film addFilm( @RequestBody Film film ) { // title, description, languageId, rentalDuration, rentalRate, replacementCost,
		LocalDateTime now = LocalDateTime.now();
		film.setLastUpdate(String.valueOf(now));
		return filmRepository.save(film);
	}

	@GetMapping("/search")
	public Iterable<Film> searchByTitle(@RequestParam String title) { return filmRepository.findByTitleContainingIgnoreCase(title); }

	@GetMapping("{id}")
	public Optional<Film> searchById(@PathVariable Integer id) { return filmRepository.findById(id); }


	@PutMapping("{id}")
	public @ResponseBody
	Film updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Film film = filmRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id."));
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
		return filmRepository.save(film);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteFilmById(@PathVariable Integer id){
		filmRepository.deleteById(id);
	}


}
