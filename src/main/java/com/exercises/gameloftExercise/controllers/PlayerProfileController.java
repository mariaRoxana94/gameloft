package com.exercises.gameloftExercise.controllers;


import com.exercises.gameloftExercise.dto.PlayerProfileDTO;
import com.exercises.gameloftExercise.services.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerProfileController {
    final private PlayerProfileService playerProfileService;

    @Autowired
    PlayerProfileController(PlayerProfileService playerProfileService) {
        this.playerProfileService = playerProfileService;
    }

    @GetMapping("/get_client_config/{player_id}")
    ResponseEntity<PlayerProfileDTO> getClientConfig(@PathVariable("player_id") String playerId) {
        PlayerProfileDTO result = playerProfileService.matchProfileWithCampaigns(playerId);
      return  ResponseEntity.ok(result);
    }
}
