package com.starAndShadow.may.websiteReboot;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {

    @Id
    @Column(name="film_id")
    private int film_id;

    //attribute
    private String title;
    private String release_year;
    private String description;

    public Film(String title, String release_year, String description) {
        this.title = title;
        this.release_year = release_year;
        this.description = description;
    }

    public Film() {}

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + film_id +
                "\"title\"= \"" + title +
                "\", \"year\"=\"" + release_year +
                "\", \"description\"=\"" + description +
                "\"}";
    }
}


