package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name="store_id")
    private int storeId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;
    @Column(name="address_id")
    private int addressId;
    private Boolean active;
    private String email;
    @Column(name="create_date")
    private String createDate;
    @Column(name="last_update")
    private String lastUpdate;
}