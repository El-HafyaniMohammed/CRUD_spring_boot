package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cne", unique = true, nullable = false, length = 50)
    private String cne;

    @Column(name = "cin", unique = true, nullable = false, length = 50)
    private String cin;

    @Column(name = "nom_candidat_ar", nullable = false, length = 255)
    private String nomCandidatAr;

    @Column(name = "prenom_candidat_ar", nullable = false, length = 255)
    private String prenomCandidatAr;

    @Column(name = "adresse", length = 500)
    private String adresse;

    @Column(name = "adresse_ar", length = 500)
    private String adresseAr;

    @Column(name = "sexe", length = 10)
    private String sexe;

    @Column(name = "ville_de_naissance", length = 100)
    private String villeDeNaissance;

    @Column(name = "ville_de_naissance_ar", length = 100)
    private String villeDeNaissanceAr;

    @Column(name = "ville", length = 100)
    private String ville;

    @Column(name = "date_de_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    @Column(name = "type_de_handicape", length = 100)
    private String typeDeHandiCape;

    @Column(name = "academie", length = 100)
    private String academie;

    @Column(name = "tel_candidat", length = 20)
    private String telCandidat;

    @Column(name = "path_cv", length = 500)
    private String pathCv;

    @Column(name = "path_photo", length = 500)
    private String pathPhoto;

    @Column(name = "etat_dossier")
    private Integer etatDossier = 0;

    @Column(name = "situation_familiale", length = 50)
    private String situationFamiliale;

    @Column(name = "pays_id")
    private Long paysId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fonctionnaire")
    private Boolean fonctionnaire = false;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // PrePersist et PreUpdate pour les dates automatiques
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}