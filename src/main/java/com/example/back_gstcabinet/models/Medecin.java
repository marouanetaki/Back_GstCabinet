package com.example.back_gstcabinet.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String CIN;
    @Column(unique = true)
    private String telephone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialite_id", nullable = true)
    private Specialite specialite;

    /*@OneToMany(mappedBy = "medecin")
    private List<Rdv> listeRdv;*/

    public Medecin(Long id, String nom, String prenom, String CIN, String telephone, Specialite specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.telephone = telephone;
        this.specialite = specialite;
    }

    public Medecin(){}

    public Medecin(String nom, String prenom, String CIN, String telephone, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.telephone = telephone;
        this.specialite = specialite;
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
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    /*public List<Rdv> getListeRdv() {
        return listeRdv;
    }

    public void setListeRdv(List<Rdv> listeRdv) {
        this.listeRdv = listeRdv;
    }*/

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CIN='" + CIN + '\'' +
                ", telephone='" + telephone + '\'' +
                ", specialite=" + specialite.toString() +
                '}';
    }
}
