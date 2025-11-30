package com.example.demo.Repository;

import com.example.demo.Entity.CandidatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<CandidatEntity, Long> {
  
}