package com.uniovi.sdi2122805labspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;

    private String dni;
    private String name;
    private String surname;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return surname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Professor() {
    }

    public Professor(Long id, String dni, String name, String surname, String category) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    @Override
    public String toString() {
        return "teacher{" + "id=" + id + ", name=" + name +  ", apellidos=" + surname +  ", categoria=" + category +'}';
    }
}
