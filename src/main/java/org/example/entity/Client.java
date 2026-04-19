package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @Override
    public String toString() {
        return id + " | " + name;
    }


    public Client() {}

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}