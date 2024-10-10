package com.exercises.gameloftExercise.services;


import com.exercises.gameloftExercise.entities.*;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class CampaignService {

    public List<Campaign> getCurrentCampaigns() {
        // set matchers
        CampaignMatchers matchers = new CampaignMatchers();
        matchers.setLevel(new LevelMatcher(1,3));

        HasMatcher hasMatcher = new HasMatcher();
        hasMatcher.setCountry(Arrays.asList("US", "RO", "CA"));
        hasMatcher.setItems(Arrays.asList("item_1"));
        matchers.setHas(hasMatcher);

        DoesNotHaveMatcher doesNotHaveMatcher = new DoesNotHaveMatcher();
        doesNotHaveMatcher.setItems(Arrays.asList("item_4"));
        matchers.setDoesNotHave(doesNotHaveMatcher);

        Campaign campaign = Campaign.builder()
                .game("mygame")
                .name("mycampaign")
                .priority(10.5)
                .startDate(ZonedDateTime.parse("2022-01-25 00:00:00Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                .endDate(ZonedDateTime.parse("2022-02-25 00:00:00Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                .lastUpdated(ZonedDateTime.parse( "2021-07-13 11:46:58Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                .enabled(true)
                .matchers(matchers)
                .build();

        return List.of(campaign);

    }
}
