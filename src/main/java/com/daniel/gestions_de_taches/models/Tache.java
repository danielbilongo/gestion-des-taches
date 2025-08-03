package com.daniel.gestions_de_taches.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
//@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tache")

public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private String responsable;
    private LocalDate dateCreation;
    private LocalDate dateEcheance;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

   public long getId() {
        return id;
   }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getResponsable() {
        return responsable;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public Statut getStatut() {
        return statut;
    }

    public Priorite getPriorite() {
        return priorite;
    }
}
