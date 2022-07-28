package com.starAndShadow.may.sakila.film;

import org.springframework.web.bind.annotation.*;

@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/add_actor")
public class FilmActorController {
    private FilmActorRepository filmActorRepository;

    public FilmActorController(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    public FilmActorRepository getFilmActorRepository() {
        return filmActorRepository;
    }

    public void setFilmActorRepository(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    // Create new film-category entry
    @PostMapping
    public @ResponseBody
    void addNewFilmActorConnection(@RequestParam int filmId, @RequestParam int categoryId) {
        FilmActor filmActor = new FilmActor(filmId, categoryId);
        filmActorRepository.save(filmActor);
    }
}