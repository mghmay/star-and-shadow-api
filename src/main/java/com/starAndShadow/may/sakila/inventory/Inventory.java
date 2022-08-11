package com.starAndShadow.may.sakila.inventory;

import com.starAndShadow.may.sakila.film.Film;
import com.starAndShadow.may.sakila.store.Store;

import javax.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private Integer inventoryId;

    //attribute
    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name="store")
    private Store store;
    @Column(name="last_update")
    private String lastUpdate;


    public Inventory() {}

    public Integer getInventoryId() {
        return inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public Store getStore() {
        return store;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + inventoryId +
                "\"film\"= \"" + film +
                "\"store\"= \"" + store +
                "\"}";
    }
}


