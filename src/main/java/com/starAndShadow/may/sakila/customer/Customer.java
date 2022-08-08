package com.starAndShadow.may.sakila.customer;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

//    @JsonIgnore

    //attribute
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="active")
    private String active;
    @Column(name="create_date")
    private String createDate;
    @Column(name="last_update")
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name="customer_id", insertable = false, updatable = false)
    private Customer customer;

    public Customer(int customerId, String firstName, String lastName, String fullName, String email, String active, String createDate, String lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void update(Map<String, Object> changes) {
        changes.forEach(
            (change, value) -> {
                switch (change) {
                    case "firstName":
                        this.setFirstName((String) value);
                        break;
                    case "lastName":
                        this.setLastName((String) value);
                        break;
                    case "email":
                        this.setEmail((String) value);
                        break;
                    case "active":
                        this.setActive((String) value);
                        break;
                }
            }
        );
        LocalDateTime now = LocalDateTime.now();
        this.setLastUpdate(String.valueOf(now));
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + customerId +
                "\"title\"= \"" + firstName +
                "\", \"year\"=\"" + lastName +
                "\"}";
    }

}


