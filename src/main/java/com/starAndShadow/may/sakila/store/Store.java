package com.starAndShadow.may.sakila.store;

import com.starAndShadow.may.sakila.film.Film;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Store {
    @Id
    @Column(name="store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;

    //attribute
    @Column(name="address_id")
    private int addressId;
    @Column(name="last_update")
    private String lastUpdate;

    public Store() {
    }

    public int getStoreId() {
        return storeId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
