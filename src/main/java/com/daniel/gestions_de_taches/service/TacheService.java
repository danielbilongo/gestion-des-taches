package com.daniel.gestions_de_taches.service;

import com.daniel.gestions_de_taches.models.Statut;
import com.daniel.gestions_de_taches.models.Tache;

import java.util.List;
import java.util.Optional;

public interface TacheService {

    Tache creerTache(Tache tache);

    Tache lireParId(Long id);

    List<Tache> lireToutesLesTache();

    List<Tache> lireTachesParStatut(Statut statut);

    Optional<Tache> modifierTache(Long id, Tache tache);

    void supprimerTache(Long id);

}
