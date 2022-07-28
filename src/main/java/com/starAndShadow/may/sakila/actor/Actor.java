package com.starAndShadow.may.sakila.actor;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

    //attribute
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

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

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + actorId +
                "\"title\"= \"" + firstName +
                "\", \"year\"=\"" + lastName +
                "\"}";
    }
}


