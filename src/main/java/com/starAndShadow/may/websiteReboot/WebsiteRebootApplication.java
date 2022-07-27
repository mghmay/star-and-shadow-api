package com.starAndShadow.may.websiteReboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/Sakila")
public class WebsiteRebootApplication {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	FilmService filmService;

	public static void main(String[] args) {
		SpringApplication.run(WebsiteRebootApplication.class, args);
	}

	public WebsiteRebootApplication(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms() { return filmRepository.findAll();}

    @GetMapping("/All_Films/{id}")
	public @ResponseBody
	Optional<Film> search(@RequestParam Integer id) {
		return filmRepository.findById(id);
	}

	@PostMapping("/All_Films/Add")
	public @ResponseBody
	Film addFilm( @RequestParam String title,
				  @RequestParam String description,
				  @RequestParam Integer language_id,
				  @RequestParam Double rental_duration,
				  @RequestParam Double rental_rate,
				  @RequestParam Double replacement_cost,
				  @RequestParam String timestamp
						  ) {
		Film newFilm = new Film(title, description, language_id, rental_duration, rental_rate, replacement_cost, timestamp);
		return filmRepository.save(newFilm);
	}
	@DeleteMapping("/All_Films/Delete")
	public @ResponseBody
	void deleteFilmById(@RequestParam Integer id){
		filmRepository.deleteById(id);
	}
}
