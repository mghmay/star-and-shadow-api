package com.starAndShadow.may.websiteReboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/Sakila")
public class WebsiteRebootApplication {

	@Autowired
	private FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WebsiteRebootApplication.class);
		application.run(args);
	}

	public WebsiteRebootApplication(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Film>getAllFilms() { return filmRepository.findAll();}
}
