package com.example.demo.controller;

import com.example.demo.model.Candidat;
import com.example.demo.services.CandidatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

  private final CandidatService candidatService;

  // Injection du service
  public CandidatController(CandidatService candidatService) {
    this.candidatService = candidatService;
  }

  // Récupérer tous les candidats
  @GetMapping
  public List<Candidat> afficherTousLesCandidats() {
    return candidatService.getTousLesCandidats();
  }

  // Récupérer un candidat par ID
  @GetMapping("/{id}")
  public Candidat afficherCandidatParId(@PathVariable Long id) {
    return candidatService.getCandidatParId(id);
  }

  // Ajouter un nouveau candidat
  @PostMapping
  public Candidat ajouterCandidat(@RequestBody Candidat candidat) {
    return candidatService.ajouterCandidat(candidat);
  }

  // Modifier un candidat existant
  @PutMapping("/{id}")
  public Candidat modifierCandidat(@PathVariable Long id, @RequestBody Candidat candidat) {
    return candidatService.modifierCandidat(id, candidat);
  }

  // Supprimer un candidat
  @DeleteMapping("/{id}")
  public List<Candidat> supprimerCandidat(@PathVariable Long id) {
    boolean supprimé = candidatService.supprimerCandidat(id);
    if (supprimé) {
      return candidatService.getTousLesCandidats(); // Retourne la liste mise à jour
    } else {
      // Si l'ID n'existe pas, on retourne la liste actuelle sans changement
      return  candidatService.getTousLesCandidats();
    }
  }

}
