package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    @ManyToMany(mappedBy = "filmActors")
    Set<Film> films;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;
    @Column(name="last_update")
    private String lastUpdate;
}


