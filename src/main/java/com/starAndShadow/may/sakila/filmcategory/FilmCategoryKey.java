package com.starAndShadow.may.sakila.filmcategory;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FilmCategoryKey implements Serializable {
    @Id
    @Column(name="film_id")
    private Integer filmId;

    @Id
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

