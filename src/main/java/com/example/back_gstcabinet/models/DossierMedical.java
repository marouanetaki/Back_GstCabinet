package com.example.back_gstcabinet.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private String dateCreation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = true)
    private Patient patient;

    public DossierMedical() {
    }

    public DossierMedical(String diagnostic, String dateCreation, Patient patient) {
        this.diagnostic = diagnostic;
        this.dateCreation = dateCreation;
        this.patient = patient;
    }

    public DossierMedical(Long id, String diagnostic, String dateCreation, Patient patient) {
        this.id = id;
        this.diagnostic = diagnostic;
        this.dateCreation = dateCreation;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
