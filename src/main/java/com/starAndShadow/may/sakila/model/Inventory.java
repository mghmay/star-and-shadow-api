package com.starAndShadow.may.sakila.model;

import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Store;

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

    @Column(name="store_id")
    private int storeId;
    @Column(name="last_update")
    private String lastUpdate;


    public Inventory() {}

    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public int getStoreId() {
        return storeId;
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


