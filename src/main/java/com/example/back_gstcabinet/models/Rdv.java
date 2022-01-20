package com.example.back_gstcabinet.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateRdv;
    private String heure;
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = true)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medecin_id", nullable = true)
    private Medecin medecin;

    public Rdv(){}

    public Rdv(Long id, String dateRdv, String heure, String note, Patient patient, Medecin medecin) {
        this.id = id;
        this.dateRdv = dateRdv;
        this.heure = heure;
        this.note = note;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Rdv(String dateRdv, String heure, String note, Patient patient, Medecin medecin) {
        this.dateRdv = dateRdv;
        this.heure = heure;
        this.note = note;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(String dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
