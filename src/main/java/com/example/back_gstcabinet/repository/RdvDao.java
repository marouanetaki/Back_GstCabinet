package com.example.back_gstcabinet.repository;

import com.example.back_gstcabinet.models.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvDao extends JpaRepository<Rdv, Long> {
}
