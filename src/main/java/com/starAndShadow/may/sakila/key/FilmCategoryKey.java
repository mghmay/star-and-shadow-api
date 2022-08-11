package com.starAndShadow.may.sakila.key;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FilmCategoryKey implements Serializable {

    @Column(name="film_id")
    private Integer filmId;

    @Column(name="category_id")
    private Integer categoryId;

    public FilmCategoryKey(Integer filmId, Integer categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategoryKey() {}

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}

