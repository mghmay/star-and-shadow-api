package com.starAndShadow.may.sakila.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
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

	@GetMapping("/search")
	public Iterable<Film> searchByTitle(@RequestParam String title) { return filmRepository.findByTitleContainingIgnoreCase(title); }

    @GetMapping("{id}")
	public Optional<Film> searchById(@PathVariable Integer id) { return filmRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Film updateFilmById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Film filmOld = filmRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id."));
		Film filmCopy = new Film(filmOld);
		changes.forEach(
				(change, value) -> {
					switch (change) {
						case "title":
							filmCopy.setTitle((String) value);
							break;
						case "description":
							filmCopy.setDescription((String) value);
							break;
						case "releaseYear":
							filmCopy.setReleaseYear((String) value);
							break;
						case "languageId":
							filmCopy.setLanguageId((Integer) value);
							break;
						case "originalLanguageId":
							filmCopy.setOriginalLanguageId((Integer) value);
							break;
						case "rentalDuration":
							filmCopy.setRentalDuration((Integer) value);
							break;
						case "rentalRate":
							filmCopy.setRentalRate((BigDecimal) value);
							break;
						case "length":
							filmCopy.setLength((Integer) value);
							break;
						case "replacementCost":
							filmCopy.setReplacementCost((BigDecimal) value);
							break;
						case "rating":
							filmCopy.setRating((String) value);
							break;
						case "specialFeatures":
							filmCopy.setSpecialFeatures((String) value);
							break;
					}
			}
		);

		return filmRepository.save(filmCopy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Film addFilm( @RequestBody Film film ) { return filmRepository.save(film); }

	@DeleteMapping("{id}")
	public @ResponseBody void deleteFilmById(@RequestParam Integer id){
		filmRepository.deleteById(id);
	}

}
