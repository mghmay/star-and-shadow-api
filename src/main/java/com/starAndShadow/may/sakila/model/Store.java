package com.starAndShadow.may.sakila.model;

import javax.persistence.*;
import java.util.Set;
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
    @Column(name="address_id")
    private int addressId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
    private Address address;

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

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + storeId +
                "\"addressId\"= \"" + addressId +
                "\"}";
    }

    public Address getAddress() {
        return address;
    }
}
