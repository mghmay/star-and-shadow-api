package com.starAndShadow.may.websiteReboot;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private int film_id;

    //attribute
    private String title;
    private String description;
    private String release_year;
    private Integer language_id;
    private Integer original_language_id;
    private Double rental_duration;
    private Double rental_rate;
    private Integer length;
    private Double replacement_cost;
//    @Enumerated(EnumType.STRING)
    private String rating;
    private String special_features;
    private String last_update;


    public Film(String title,
                String description,
                String release_year,
                Integer language_id,
                Integer original_language_id,
                Double rental_duration,
                Double rental_rate,
                Integer length,
                Double replacement_cost,
                String rating,
                String special_features,
                String last_update) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.original_language_id = original_language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
    }

    public Film(String title,
                String description,
                Integer language_id,
                Double rental_duration,
                Double rental_rate,
                Double replacement_cost,
                String last_update) {
        this.title = title;
        this.description = description;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.last_update = last_update;
    }

    public Film() {}

    public Integer getFilm_id() {
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

    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    public Integer getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id) {
        this.original_language_id = original_language_id;
    }

    public Double getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Double rental_duration) {
        this.rental_duration = rental_duration;
    }

    public Double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(Double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(Double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
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


