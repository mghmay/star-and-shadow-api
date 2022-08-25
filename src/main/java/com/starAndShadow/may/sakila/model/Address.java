package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="address")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(name = "address")
    private String addressName;
    @Column(name = "address2")
    private String addressName2;
    @Column(name = "district")
    private String district;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone")
    private String phone;
    @Column(name = "location")
    private String location;
    @Column(name = "last_update")
    private String lastUpdate;
}