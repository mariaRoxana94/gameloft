package com.exercises.gameloftExercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerProfileDTO {

    private UUID playerId;
    private String credential;

    private ZonedDateTime created;
    private ZonedDateTime modified;
    private ZonedDateTime lastSession;

    private Integer totalSpent;
    private Integer totalRefund;
    private Integer totalTransactions;
    private ZonedDateTime lastPurchase;

    private List<String> activeCampaigns;
    private List<DeviceDTO> devices;

    private Integer level;
    private Integer xp;
    private Integer totalPlaytime;
    private String country;
    private String language;
    private ZonedDateTime birthdate;
    private String gender;
    private InventoryDTO inventory;

    private ClanDTO clan;

    private String customfield;
}
