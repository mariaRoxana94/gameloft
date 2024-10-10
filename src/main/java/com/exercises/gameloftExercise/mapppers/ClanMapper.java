package com.exercises.gameloftExercise.mapppers;


import com.exercises.gameloftExercise.dto.ClanDTO;
import com.exercises.gameloftExercise.entities.Clan;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClanMapper {

    ClanDTO fromClan(Clan clan);
    Clan fromClanDTO(ClanDTO clan);
}
