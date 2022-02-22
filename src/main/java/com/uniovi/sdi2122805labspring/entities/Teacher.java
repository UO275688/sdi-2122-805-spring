package com.uniovi.sdi2122805labspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private String dni;
    private String name;
    private String lastName;
    private String category;

    public String getDni() {
        return dni;
    }

    public void setId(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Teacher() {
    }

    public Teacher(String dni, String name, String lastName, String category) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "teacher{" + "id=" + dni + ", name=" + name +  ", apellidos=" + lastName +  ", categoria=" + category +'}';
    }
}
