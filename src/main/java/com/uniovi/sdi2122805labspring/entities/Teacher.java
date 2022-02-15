package com.uniovi.sdi2122805labspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellidos;
    private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    /*public Teacher() {
    }

    public Teacher(Long id, String nombre, String apellidos, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.categoria = categoria;
    }*/

    @Override
    public String toString() {
        return "teacher{" + "id=" + id + ", name=" + nombre +  ", apellidos=" + apellidos +  ", categoria=" + categoria +'}';
    }
}
