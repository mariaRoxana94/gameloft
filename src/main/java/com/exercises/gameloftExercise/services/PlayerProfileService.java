package com.exercises.gameloftExercise.services;

import com.exercises.gameloftExercise.dto.PlayerProfileDTO;

public interface PlayerProfileService {

    PlayerProfileDTO matchProfileWithCampaigns(String playerId);
}
