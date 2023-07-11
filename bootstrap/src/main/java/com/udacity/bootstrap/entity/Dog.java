package com.udacity.bootstrap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Breed;
    private String Origin;


    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.Name = name;
        this.Breed = breed;
        this.Origin = origin;
    }

    public Dog() {

    }

    public Dog(String name, String breed, String origin) {
        this.Name = name;
        this.Breed = breed;
        this.Origin = origin;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
