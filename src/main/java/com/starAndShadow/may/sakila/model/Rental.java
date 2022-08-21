package com.starAndShadow.may.sakila.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_id")
    private Integer rentalId;
    @Column(name="rental_date")
    private String rentalDate;
    @Column(name="inventory_id")
    private Integer inventoryId;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="staff_id")
    private Integer staffId;
    @Column(name="last_update")
    private String lastUpdate;
}
