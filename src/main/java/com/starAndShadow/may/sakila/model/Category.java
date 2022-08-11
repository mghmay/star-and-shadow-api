package com.starAndShadow.may.sakila.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    //attribute
    @Column(name="name")
    private String name;

    @Column(name="last_update")
    private String lastUpdate;

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String last) {
        this.lastUpdate = last;
    }

    public void update(Map<String, Object> changes) {
        changes.forEach(
            (change, value) -> {
            switch (change) {
                case "name":
                    this.setName((String) value);
                    break;
            }
        });
        LocalDateTime now = LocalDateTime.now();
        this.setLastUpdate(String.valueOf(now));
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + categoryId +
                "\"name\"= \"" + name +
                "\"}";
    }
}

