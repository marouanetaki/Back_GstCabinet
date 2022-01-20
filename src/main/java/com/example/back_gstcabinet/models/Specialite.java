package com.example.back_gstcabinet.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialite;

    public Specialite(Long id, String specialite) {
        this.id = id;
        this.specialite = specialite;
    }

    public Specialite(){}

    public Specialite(String specialite) {
        this.specialite = specialite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }


    @Override
    public String toString() {
        return "Specialite{" +
                "id=" + id +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
