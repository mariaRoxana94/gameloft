package com.exercises.gameloftExercise.services;


import com.exercises.gameloftExercise.dto.PlayerProfileDTO;
import com.exercises.gameloftExercise.entities.*;
import com.exercises.gameloftExercise.mapppers.PlayerProfileMapper;
import com.exercises.gameloftExercise.repositories.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {
    final private PlayerProfileRepository playerProfileRepository;
    final private CampaignService campaignService;

    final private PlayerProfileMapper mapper;


    @Autowired
    PlayerProfileServiceImpl(PlayerProfileRepository playerProfileRepository, CampaignService campaignService, PlayerProfileMapper mapper) {
        this.playerProfileRepository = playerProfileRepository;
        this.campaignService = campaignService;
        this.mapper = mapper;

    }

    @Override
    public PlayerProfileDTO matchProfileWithCampaigns(String playerId) {

        // 1) get player from db
        PlayerProfile playerProfile = playerProfileRepository.findById(UUID.fromString(playerId))
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        // 2) take the curr campaigns
        List<Campaign> activeCampaigns = campaignService.getCurrentCampaigns();


        // 3) check profile with each campaign
        for (Campaign campaign : activeCampaigns) {
            if (isCampaignMatching(playerProfile, campaign)) {
                // 4) if match, add campaign name to active campaigns of the profile
                playerProfile.getActiveCampaigns().add(campaign.getName());
            }
        }

        // 5) save the updated profile
        playerProfileRepository.save(playerProfile);

        return mapper.fromPlayer(playerProfile);
    }

    private boolean isCampaignMatching(PlayerProfile profile, Campaign campaign) {

        // enabled or not ?
        if (!campaign.getEnabled()) {
            return false;
        }

        // validate level
        LevelMatcher levelMatcher = campaign.getMatchers().getLevel();
        if (profile.getLevel() < levelMatcher.getMin() || profile.getLevel() > levelMatcher.getMax()) {
            return false;
        }

        // validate country
        HasMatcher hasMatcher = campaign.getMatchers().getHas();
        if (!hasMatcher.getCountry().contains(profile.getCountry())) {
            return false;
        }

        // validate inventory items
        for (String requiredItem : hasMatcher.getItems()) {
            if (!profile.getInventory().getItems().containsKey(requiredItem)) {
                return false;
            }
        }

        // check for "does not have" items
        DoesNotHaveMatcher doesNotHaveMatcher = campaign.getMatchers().getDoesNotHave();
        for (String forbiddenItem : doesNotHaveMatcher.getItems()) {
            if (profile.getInventory().getItems().containsKey(forbiddenItem)) {
                return false;
            }
        }

        return true;
    }
}

