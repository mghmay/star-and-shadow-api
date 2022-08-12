package com.starAndShadow.may.sakila.model;

import com.starAndShadow.may.sakila.model.Inventory;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
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
    private Integer releaseYear;
    @Column(name = "language_id")
    private Integer languageId;
    @ManyToOne
    @JoinColumn(name="language_id", insertable = false, updatable = false)
    private Language language;
    @OneToMany(mappedBy="film", fetch = FetchType.LAZY)
    private Set<Inventory> inventory;
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

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Category> filmCategory;

    @ManyToMany
            @JoinTable(
                    name="film_actor",
                    joinColumns = @JoinColumn(name = "film_id"),
                    inverseJoinColumns = @JoinColumn(name = "actor_id")
            )
    Set<Actor> filmActors;
    @Column(name="last_update")
    private String lastUpdate;
    // constructors
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
    // getters, setters, methods
    public Integer getFilmId() {
        return filmId;
    }
    public Set<Category> getFilmCategory() {
        return filmCategory;
    }
    public void setFilmCategory(Set<Category> filmCategory) {
        this.filmCategory = filmCategory;
    }
    public String getTitle() {
        return title;
    }
    public Set<Inventory> getInventory() { return inventory; }
    public Set<Actor> getActors() {
        return filmActors;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    public Language getLanguage() {
        return language;
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
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
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


