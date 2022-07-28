package com.starAndShadow.may.sakila.film;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="film_actor")
public class FilmActor implements Serializable {
    @Id
    @Column(name="film_id")
    private int filmId;
    @Id
    @Column(name="actor_id")
    private int actorId;

    public FilmActor(int filmId, int actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public FilmActor() {}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
}