package com.starAndShadow.may.sakila.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

//    @JsonIgnore
    @ManyToMany(mappedBy = "filmActors")
    Set<Film> films;

    //attribute
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @Column(name="last_update")
    private String lastUpdate;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor() {}

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
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
                    }
                }
        );
        LocalDateTime now = LocalDateTime.now();
        this.setLastUpdate(String.valueOf(now));
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + actorId +
                "\"title\"= \"" + firstName +
                "\", \"year\"=\"" + lastName +
                "\"}";
    }

}


