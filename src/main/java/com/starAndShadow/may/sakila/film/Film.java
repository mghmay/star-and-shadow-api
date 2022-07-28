package com.starAndShadow.may.sakila.film;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private Integer filmId;

    //attribute
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="release_year")
    private String releaseYear;
    @Column(name="language_id")
    private Integer languageId;
    @Column(name="original_language_id")
    private Integer originalLanguageId;
    @Column(name="rental_duration")
    private Integer rentalDuration;
    @Column(name="rental_rate")
    private BigDecimal rentalRate;
    @Column(name="length")
    private Integer length;
    @Column(name="replacement_cost")
    private BigDecimal replacementCost;
    @Column(name="rating")
    private String rating;
    @Column(name="special_features")
    private String specialFeatures;
    @Column(name="last_update", insertable=false)
    private String lastUpdate;

    public Film(String title,
                String description,
                Integer languageId,
                Integer rentalDuration,
                BigDecimal rentalRate,
                BigDecimal replacementCost ) {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }

    public Film(Film film) {
        this.filmId = film.filmId;
        this.title = film.title;
        this.description = film.description;
        this.releaseYear = film.releaseYear;
        this.languageId = film.languageId;
        this.originalLanguageId = film.originalLanguageId;
        this.rentalDuration = film.rentalDuration;
        this.rentalRate = film.rentalRate;
        this.length = film.length;
        this.replacementCost = film.replacementCost;
        this.rating = film.rating;
        this.specialFeatures = film.specialFeatures;
        this.lastUpdate = film.lastUpdate;
    }

    public Film() {}

    public Integer getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + filmId +
                "\"title\"= \"" + title +
                "\", \"year\"=\"" + releaseYear +
                "\", \"description\"=\"" + description +
                "\"}";
    }
}


