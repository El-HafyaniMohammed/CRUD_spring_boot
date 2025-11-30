package com.example.demo.controller;

import com.example.demo.Entity.CandidatEntity;
import com.example.demo.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    // Get all candidates
    @GetMapping
    public List<CandidatEntity> getAllCandidates() {
        return candidatService.getAllCondidat();
    }

    // Get candidate by ID
    @GetMapping("/{id}")
    public CandidatEntity getCandidateById(@PathVariable Long id) {
        return candidatService.getCandidatById(id);
    }

    // Add new candidate
    @PostMapping
    public CandidatEntity addCandidate(@RequestBody CandidatEntity candidat) {
        return candidatService.ajouterCandidat(candidat);
    }

    // Update candidate
    @PutMapping("/{id}")
    public CandidatEntity updateCandidate(@PathVariable Long id, @RequestBody CandidatEntity candidat) {
        return candidatService.modifierCandidat(candidat);
    }

    // Delete candidate
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidatService.supprimerCandidat(id);
    }
}