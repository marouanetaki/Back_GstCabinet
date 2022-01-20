package com.example.back_gstcabinet.controller;

import com.example.back_gstcabinet.models.Specialite;
import com.example.back_gstcabinet.repository.SpecialiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SpecialiteWb {

    @Autowired
    SpecialiteDao spDao;

    @GetMapping("/specialites")
    public List<Specialite> findAll(){
        return spDao.findAll();
    }
    
    @PostMapping("/specialites")
    public Specialite create(@RequestBody Specialite sp){
        return spDao.save(sp);
    }

    @GetMapping("/specialites/{id}")
    public ResponseEntity<Optional<Specialite>> findById(@PathVariable Long id){
        Optional<Specialite> specialite = spDao.findById(id);
        return ResponseEntity.ok(specialite);
    }

    // update Employee
    @PutMapping("/specialites/{id}")
    public ResponseEntity<Specialite> update(@PathVariable Long id, @RequestBody Specialite spDetails){
        Specialite specialite = spDao.getById(id);
        specialite.setSpecialite(spDetails.getSpecialite());
        Specialite update = spDao.save(specialite);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/specialites/statistiques")
    public List<String> nbrSpecialite(){
        return spDao.nbrMedecinParSpecialite();
    }

    // Delete Employee
    @DeleteMapping("/specialites/{id}")
    public void delete(@PathVariable Long id){
        Specialite specialite = spDao.getById(id);
        spDao.delete(specialite);
    }
}
