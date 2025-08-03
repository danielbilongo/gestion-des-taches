package com.daniel.gestions_de_taches.mapper;


import com.daniel.gestions_de_taches.dto.TacheDto;
import com.daniel.gestions_de_taches.models.Tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    Tache toEntity(TacheDto dto);
    TacheDto toDTO(Tache tache);
}