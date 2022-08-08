package com.starAndShadow.may.sakila.staff;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name="staff")
public class Staff {
    @Id
    @Column(name="staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;

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
    @Column(name="create_date")
    private String createDate;
    @Column(name="last_update")
    private String lastUpdate;

    public Staff(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Staff() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                }
            }
        );
        LocalDateTime now = LocalDateTime.now();
        this.setLastUpdate(String.valueOf(now));
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + staffId +
                "\"title\"= \"" + firstName +
                "\", \"year\"=\"" + lastName +
                "\"}";
    }

}


