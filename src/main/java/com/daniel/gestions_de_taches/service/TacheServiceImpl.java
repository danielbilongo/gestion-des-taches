package com.daniel.gestions_de_taches.service;


import com.daniel.gestions_de_taches.models.Statut;
import com.daniel.gestions_de_taches.models.Tache;
import com.daniel.gestions_de_taches.repository.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class TacheServiceImpl implements TacheService {

    private final TacheRepository tacheRepository;

    // Injection par constructeur
    public TacheServiceImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }


    //methode pour sauvegarder une tache
    @Override
    public Tache creerTache(Tache tache) {
        Optional<Tache> existante = tacheRepository.findByTitreAndDescription(
                tache.getTitre(), tache.getDescription()
        );
        if (existante.isPresent()) {
            throw new IllegalArgumentException("Une tâche avec ce titre et cette description existe déjà.");
        }

        tache.setDateCreation(java.time.LocalDate.now());
        return tacheRepository.save(tache);
    }

    //lire tache par son id
    @Override
    public Tache lireParId(Long id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tâche avec l'ID " + id + " introuvable."));
    }

    //methode pour lister toute les taches
    @Override
    public List<Tache> lireToutesLesTache() {
        return tacheRepository.findAll();
    }



    //methode pour lister les tache par leur statut
    public List<Tache> lireTachesParStatut(Statut statut) {

        return tacheRepository.findByStatut(statut);
    }


    //methode pour modifier une tache
    @Override
    public Optional<Tache> modifierTache(Long id, Tache tache) {
        return tacheRepository.findById(id).map(t ->{
            t.setTitre(tache.getTitre());
            t.setDescription(tache.getDescription());
            t.setStatut(tache.getStatut());
            t.setPriorite(tache.getPriorite());
            t.setResponsable(tache.getResponsable());
            t.setDateEcheance(tache.getDateEcheance());


            return tacheRepository.save(t);

        });
    }


    //methode pour supprimer une tache
    @Override
    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }


}

