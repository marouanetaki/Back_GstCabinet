package com.example.back_gstcabinet.controller;

import com.example.back_gstcabinet.models.DossierMedical;
import com.example.back_gstcabinet.repository.DossierMedicalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1")
public class DossierMedicalWb {

    @Autowired
    DossierMedicalDao dossierDao;

    @GetMapping("/dossiers")
    public List<DossierMedical> findAll(){
        return dossierDao.findAll();
    }

    @PostMapping("/dossiers")
    public DossierMedical create(@RequestBody DossierMedical ds){
        return dossierDao.save(ds);
    }

    @GetMapping("/dossiers/{id}")
    public Optional<DossierMedical> findById(@PathVariable Long id){
        return dossierDao.findById(id);
    }

    // update Employee
    @PutMapping("/dossiers/{id}")
    public ResponseEntity<DossierMedical> update(@PathVariable Long id, @RequestBody DossierMedical dsDetails){
        DossierMedical dossier = dossierDao.getById(id);
        dossier.setDiagnostic(dsDetails.getDiagnostic());
        dossier.setPatient(dsDetails.getPatient());
        dossier.setDateCreation(dsDetails.getDateCreation());
        DossierMedical update = dossierDao.save(dossier);
        return ResponseEntity.ok(update);
    }

    // Delete Employee
    @DeleteMapping("/dossiers/{id}")
    public void delete(@PathVariable Long id){
        DossierMedical dossier = dossierDao.getById(id);
        dossierDao.delete(dossier);
    }
}
