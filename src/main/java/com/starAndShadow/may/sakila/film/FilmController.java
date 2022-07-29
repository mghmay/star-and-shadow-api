package com.starAndShadow.may.sakila.film;

import com.starAndShadow.may.sakila.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

	@ManyToMany
	@JoinTable(
			name = "film_actor",
			joinColumns = @JoinColumn(name = "film_id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id")
	)
	List<Actor> filmActor = new ArrayList<>();

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
		film.update(changes);
		return filmRepository.save(film);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteFilmById(@PathVariable Integer id){
		filmRepository.deleteById(id);
	}


}
