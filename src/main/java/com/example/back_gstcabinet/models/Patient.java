package com.example.back_gstcabinet.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String cin;
    private String sex;
    @Column(unique = true)
    private String telephone;
    private String dateNaissance;

    /*
    @OneToMany(mappedBy = "patient")
    private List<Rdv> listeRdv;

    @OneToMany(mappedBy = "patient")
    private List<DossierMedical> listeDossier;
    */

    public Patient(Long id, String nom, String prenom, String CIN, String sex, String telephone, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = CIN;
        this.sex = sex;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
    }

    public Patient(){}

    public Patient(String nom, String prenom, String CIN, String sex, String telephone, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = CIN;
        this.sex = sex;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCIN() {
        return cin;
    }

    public void setCIN(String CIN) {
        this.cin = CIN;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CIN='" + cin + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
