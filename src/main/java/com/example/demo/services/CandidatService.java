package com.example.demo.services;

import com.example.demo.Entity.CandidatEntity;
import com.example.demo.Repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CandidatService {

  @Autowired
  CandidatRepository candidatRepository;

  // fonction return all candidats
  public List<CandidatEntity> getAllCondidat() {
    return candidatRepository.findAll();
  }

  // fonction return candidat by id
  public CandidatEntity getCandidatById(Long id) {
    return candidatRepository.findById(id).orElse(null);
  }

  // fonction ajouter candidat
  public CandidatEntity ajouterCandidat(CandidatEntity candidat) {
    return candidatRepository.save(candidat);
  }

  // fonction modifier candidat
  public CandidatEntity modifierCandidat(CandidatEntity candidat) {
    return candidatRepository.save(candidat);
  }

  // fonction supprimer candidat
  public void supprimerCandidat(Long id) {
    candidatRepository.deleteById(id);
  }
}