package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="language")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private int languageId;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy="languageId")
    private Set<Language> languages;
    @Column(name="last_update")
    private String lastUpdate;
    public Language(String name) {
        this.name = name;
    }
}
