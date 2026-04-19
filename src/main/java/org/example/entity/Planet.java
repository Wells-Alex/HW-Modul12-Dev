package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    private String name;

    @Override
    public String toString() {
        return id + " | " + name;
    }

    public Planet() {}

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setId(String id) { this.id = id; }
}