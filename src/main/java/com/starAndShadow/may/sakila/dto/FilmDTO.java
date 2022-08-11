package com.starAndShadow.may.sakila.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
    @Getter(AccessLevel.NONE)
    private Integer languageId;
    @Getter(AccessLevel.NONE)
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    @Getter(AccessLevel.NONE)
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    @Getter(AccessLevel.NONE)
    private String lastUpdate;
    private List cast;
    private Map<Integer, Long> inventory;
    private String category;
}
