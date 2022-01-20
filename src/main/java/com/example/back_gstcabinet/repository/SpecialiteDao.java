package com.example.back_gstcabinet.repository;

import com.example.back_gstcabinet.models.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Long> {

    @Query("SELECT COUNT(m.id), sp.specialite FROM Medecin m join Specialite sp on m.specialite.id = sp.id group by sp.specialite")
    List<String> nbrMedecinParSpecialite();

}
