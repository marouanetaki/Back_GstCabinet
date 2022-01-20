package com.example.back_gstcabinet.repository;

import com.example.back_gstcabinet.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinDao extends JpaRepository<Medecin, Long> {
}
