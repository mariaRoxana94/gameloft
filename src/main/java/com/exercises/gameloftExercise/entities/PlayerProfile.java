package com.exercises.gameloftExercise.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID playerId;
    private String credential;


    private ZonedDateTime  created;
    private ZonedDateTime  modified;
    private ZonedDateTime  lastSession;

    private Integer totalSpent;
    private Integer totalRefund;
    private Integer totalTransactions;

    private ZonedDateTime lastPurchase;

    @ElementCollection
    private Set<String> activeCampaigns;

    // a player can be logged in on several devices like phone, tablet, computer etc
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_Id")
    private List<Device> devices;

    private Integer level;
    private Integer xp;
    private Integer totalPlaytime;
    private String country;
    private String language;
    private ZonedDateTime birthdate;
    private String gender;

    @Embedded
    private Inventory inventory;

    @Embedded
    private Clan clan;

    @Column(name = "_customfield")
    private String customfield;


}
