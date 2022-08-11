package com.starAndShadow.may.sakila.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class FilmDTO {
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private String language;
    @JsonIgnore
    private Integer languageId;
    @JsonIgnore
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    @JsonIgnore
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    @JsonIgnore
    private String lastUpdate;
    private List cast;
    private Map<Integer, Long> inventory;
    private String category;
}
