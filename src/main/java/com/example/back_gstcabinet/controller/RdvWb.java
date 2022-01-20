package com.example.back_gstcabinet.controller;

import com.example.back_gstcabinet.models.Rdv;
import com.example.back_gstcabinet.repository.RdvDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RdvWb {

    @Autowired
    RdvDao rdvDao;

    @GetMapping("/rdvs")
    public List<Rdv> findAll(){
        return rdvDao.findAll();
    }

    @PostMapping("/rdvs")
    public Rdv create(@RequestBody Rdv sp){
        return rdvDao.save(sp);
    }

    @GetMapping("/rdvs/{id}")
    public Optional<Rdv> findById(@PathVariable Long id){
        return rdvDao.findById(id);
    }

    // update Employee
    @PutMapping("/rdvs/{id}")
    public ResponseEntity<Rdv> update(@PathVariable Long id, @RequestBody Rdv newRdv){
        Rdv rdv = rdvDao.getById(id);
        rdv.setDateRdv(newRdv.getDateRdv());
        rdv.setHeure(newRdv.getHeure());
        rdv.setMedecin(newRdv.getMedecin());
        rdv.setNote(newRdv.getNote());
        rdv.setPatient(newRdv.getPatient());
        Rdv update = rdvDao.save(rdv);
        return ResponseEntity.ok(update);
    }

    // Delete Employee
    @DeleteMapping("/rdvs/{id}")
    public void delete(@PathVariable Long id){
        Rdv specialite = rdvDao.getById(id);
        rdvDao.delete(specialite);
    }
}
