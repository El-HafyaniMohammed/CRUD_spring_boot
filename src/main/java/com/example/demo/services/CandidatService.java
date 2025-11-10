package com.example.demo.services;

import com.example.demo.model.Candidat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CandidatService {

    private List<Candidat> candidats = new ArrayList<>();

    
    public CandidatService() {
        candidats.add(new Candidat(
                1L, "CNE001", "AA123456",
                "Elhafyani", "Mohammed",
                "Rue Hassan II", "rachidia",
                "Homme", "Fès", "rachidia", "Fès",
                new Date(), "Aucun", "Académie Fès-Meknès",
                "0612345678", "/cv/mohammed.pdf",
                "/photo/mohammed.jpg", 1,
                "Célibataire", 1L, 10, false
        ));
    }

  
    public List<Candidat> getTousLesCandidats() {
        return candidats;
    }

    public Candidat getCandidatParId(Long id) {
        return candidats.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Candidat ajouterCandidat(Candidat candidat) {
        candidat.setId((long) (candidats.size() + 1));
        candidats.add(candidat);
        return candidat;
    }

    public Candidat modifierCandidat(Long id, Candidat nouveauCandidat) {
        for (int i = 0; i < candidats.size(); i++) {
            if (candidats.get(i).getId().equals(id)) {
                nouveauCandidat.setId(id);
                candidats.set(i, nouveauCandidat);
                return nouveauCandidat;
            }
        }
        return null;
    }

    // 🔹 Supprimer un candidat
    public boolean supprimerCandidat(Long id) {
        return candidats.removeIf(c -> c.getId().equals(id));
    }
}
