package com.exercises.gameloftExercise.entities;
import lombok.Data;


@Data
public class CampaignMatchers {

    private LevelMatcher level;
    private HasMatcher has;
    private DoesNotHaveMatcher doesNotHave;
}
