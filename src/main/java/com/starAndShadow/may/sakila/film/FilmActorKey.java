package com.starAndShadow.may.sakila.film;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FilmActorKey implements Serializable {
    @Id
    @Column(name="film_id")
    private Integer filmId;

    @Id
    @Column(name="actor_id")
    private Integer actorId;

    public FilmActorKey(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public FilmActorKey() {}

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}