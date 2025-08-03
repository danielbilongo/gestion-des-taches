package com.daniel.gestions_de_taches.dto;

import java.time.LocalDate;
import com.daniel.gestions_de_taches.models.Priorite;
import com.daniel.gestions_de_taches.models.Statut;
import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TacheDto {
    private String titre;
    private String description;
    private Statut statut;
    private Priorite priorite;
    private String responsable;
    private LocalDate dateEcheance;
}
