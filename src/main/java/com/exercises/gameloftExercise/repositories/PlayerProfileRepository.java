package com.exercises.gameloftExercise.repositories;

import com.exercises.gameloftExercise.entities.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, UUID> {
}
