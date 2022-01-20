package com.example.back_gstcabinet.controller;

import com.example.back_gstcabinet.models.Patient;
import com.example.back_gstcabinet.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PatientWb {

    @Autowired
    PatientDao patientDao;

    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @PostMapping("/patients")
    public Patient save(@RequestBody Patient entity) {
        return patientDao.save(entity);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient newpt){
        Patient pt = patientDao.getById(id);
        pt.setNom(newpt.getNom());
        pt.setCIN(newpt.getCIN());
        pt.setDateNaissance(newpt.getDateNaissance());
        pt.setPrenom(newpt.getPrenom());
        pt.setSex(newpt.getSex());
        pt.setTelephone(newpt.getTelephone());
        Patient update = patientDao.save(pt);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {
        return patientDao.findById(id);
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Long id) {
        patientDao.deleteById(id);
    }
}
