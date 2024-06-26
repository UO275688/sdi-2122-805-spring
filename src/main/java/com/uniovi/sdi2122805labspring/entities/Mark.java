package com.uniovi.sdi2122805labspring.entities;

import javax.persistence.*;

@Entity
public class Mark {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double score;
    private Boolean resend = false;

    @ManyToOne
    @JoinColumn(name = "user_id") //especifica la columna que va a crear una asociación entres las entidades.
    private User user;

    public Mark() {
    }

    public Mark(String description, Double score, User user) {
        this.description = description;
        this.score = score;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getResend() {
        return resend;
    }

    public void setResend(Boolean resend) {
        this.resend = resend;
    }

    @Override
    public String toString() {
        return "Mark{" + "id=" + id + ", description='" + description + '\'' + ", score=" + score + '}';
    }
}
