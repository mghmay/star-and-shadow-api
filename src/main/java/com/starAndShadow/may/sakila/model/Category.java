package com.starAndShadow.may.sakila.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    @Column(name="last_update")
    private String lastUpdate;
    @ManyToMany(mappedBy = "filmCategory")
    private Set<Film> filmCategory;
}

