package com.exercises.gameloftExercise.entities;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;


@Data
@Builder
public class Campaign {

    private String game;
    private String name;
    private Double priority;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Boolean enabled;
    private ZonedDateTime lastUpdated;

    private CampaignMatchers matchers;  // Campaign matchers

}
