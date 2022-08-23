package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="store")
public class Store {
    @Id
    @Column(name="store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    @OneToMany(mappedBy = "store")
    private Set<Inventory> inventory;
    //attribute
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
    private Address address;
    @Column(name="last_update")
    private String lastUpdate;
}
