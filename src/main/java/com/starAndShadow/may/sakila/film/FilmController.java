package com.starAndShadow.may.sakila.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

//	@PatchMapping("{id}")
//	public @ResponseBody
//	void updateFilmById(@RequestParam Integer id, @RequestBody Film film) {
//		Film filmOld = filmRepository.findById(id).get();
//
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Film addFilm( @RequestBody Film film ) { return filmRepository.save(film); }

	@DeleteMapping("{id}")
	public @ResponseBody void deleteFilmById(@RequestParam Integer id){
		filmRepository.deleteById(id);
	}
}
