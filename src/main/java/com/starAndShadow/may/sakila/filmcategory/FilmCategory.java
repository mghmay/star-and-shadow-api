package com.starAndShadow.may.sakila.filmcategory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="film_category")
@IdClass(FilmCategoryKey.class)
public class FilmCategory implements Serializable {
    @Id
    private int filmId;
    @Id
    private int categoryId;

    public FilmCategory(int filmId, int categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategory() {}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}