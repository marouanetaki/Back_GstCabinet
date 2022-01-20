package com.example.back_gstcabinet.repository;

import com.example.back_gstcabinet.models.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalDao extends JpaRepository<DossierMedical, Long> {
}
