package com.starAndShadow.may.sakila.model;

import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Getter
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private Integer inventoryId;
    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name="store_id", updatable = false, insertable = false)
    private Store store;
    @Column(name="last_update")
    private String lastUpdate;
}


