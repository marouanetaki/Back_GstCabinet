package com.example.back_gstcabinet.controller;

import com.example.back_gstcabinet.models.Medecin;
import com.example.back_gstcabinet.repository.MedecinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MedecinWb {

    @Autowired
    MedecinDao medecinDao;

    @GetMapping("/medecins")
    public List<Medecin> findAll() {
        return medecinDao.findAll();
    }

    @PostMapping("/medecins")
    public Medecin save(@RequestBody Medecin entity) {
        return medecinDao.save(entity);
    }

    @PutMapping("/medecins/{id}")
    public ResponseEntity<Medecin> update(@PathVariable Long id, @RequestBody Medecin newmd){
        Medecin md = medecinDao.getById(id);
        md.setNom(newmd.getNom());
        md.setCIN(newmd.getCIN());
        md.setPrenom(newmd.getPrenom());
        md.setTelephone(newmd.getTelephone());
        md.setSpecialite(newmd.getSpecialite());
        Medecin update = medecinDao.save(newmd);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/medecins/{id}")
    public Optional<Medecin> findById(@PathVariable Long id) {
        return medecinDao.findById(id);
    }

    @DeleteMapping("/medecins/{id}")
    public void delete(@PathVariable Long id) {
        medecinDao.deleteById(id);
    }


}
