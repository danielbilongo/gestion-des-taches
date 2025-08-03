package com.daniel.gestions_de_taches.controller;


import com.daniel.gestions_de_taches.dto.TacheDto;
import com.daniel.gestions_de_taches.mapper.TacheMapper;
import com.daniel.gestions_de_taches.models.Statut;
import com.daniel.gestions_de_taches.models.Tache;
import com.daniel.gestions_de_taches.service.TacheService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tags;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;


@RestController
@Tags
@RequestMapping("/api/taches")
public class TacheController {

    private final TacheService tacheService;
    private final TacheMapper tacheMapper;

    //  Injection par constructeur
    public TacheController(TacheService tacheService, TacheMapper tacheMapper) {
        this.tacheService = tacheService;
        this.tacheMapper = tacheMapper;
    }


    @Operation(summary = "Créer une nouvelle tâche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tâche créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping
    public ResponseEntity<TacheDto> creerTache(@RequestBody TacheDto dto) {
        Tache tache = tacheMapper.toEntity(dto);
        Tache cree = tacheService.creerTache(tache);
        return ResponseEntity.ok(tacheMapper.toDTO(cree));
    }


    @Operation(summary = "Lire toutes les tâches")
    @GetMapping
    public ResponseEntity<List<TacheDto>> lireToutesLesTaches() {
        return ResponseEntity.ok(
                tacheService.lireToutesLesTache().stream().map(tacheMapper::toDTO).toList()
        );
    }

    @Operation(summary = "Lire les taches par leur Id")
    @GetMapping("/{id}")
    public ResponseEntity<TacheDto> lireParId(@PathVariable Long id) {
        return ResponseEntity.ok(
                tacheMapper.toDTO(tacheService.lireParId(id))
        );
    }

    @Operation(summary = "Lire les tâches par statut")
    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<TacheDto>> lireTachesParStatut(@PathVariable Statut statut) {
        return ResponseEntity.ok(
                tacheService.lireTachesParStatut(statut).stream().map(tacheMapper::toDTO).toList()
        );
    }



    @Operation(summary = "Modifier une tâche existante")
    @PutMapping("/{id}")
    public Object modifierTache(@PathVariable Long id, @RequestBody TacheDto dto) {
        Optional<Tache> modifie = tacheService.modifierTache(id, tacheMapper.toEntity(dto));
        return modifie.map((Function<? super Tache, ?>) t -> ResponseEntity.ok(tacheMapper.toDTO(t)))
                .orElseThrow(() -> new NoSuchElementException("Tâche non trouvée"));
    }


    @Operation(summary = "Supprimer une tâche")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
        return ResponseEntity.noContent().build();
    }

}
