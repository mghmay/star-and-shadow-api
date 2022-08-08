package com.starAndShadow.may.sakila.filmcategory;

import org.springframework.web.bind.annotation.*;

@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/film_category")
public class FilmCategoryController {
    private FilmCategoryRepository filmCategoryRepository;

    public FilmCategoryController(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }

    public FilmCategoryRepository getFilmCategoryRepository() {
        return filmCategoryRepository;
    }

    public void setFilmCategoryRepository(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }

    @GetMapping
    public Iterable<FilmCategory>getAllFilmsByCategory() { return filmCategoryRepository.findAll();}

    // Create new film-category entry
    @PostMapping
    public @ResponseBody
    void addNewFilmCategoryConnection(@RequestParam int filmId, @RequestParam int categoryId) {
        FilmCategory filmCategory = new FilmCategory(filmId, categoryId);
        filmCategoryRepository.save(filmCategory);
    }
}