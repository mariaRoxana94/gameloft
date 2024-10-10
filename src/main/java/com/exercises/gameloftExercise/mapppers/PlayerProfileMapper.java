package com.exercises.gameloftExercise.mapppers;


import com.exercises.gameloftExercise.dto.PlayerProfileDTO;
import com.exercises.gameloftExercise.entities.PlayerProfile;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PlayerProfileMapper {


    PlayerProfileDTO fromPlayer(PlayerProfile playerProfile);
    PlayerProfile fromPlayerDTO(PlayerProfileDTO playerProfile);
}
