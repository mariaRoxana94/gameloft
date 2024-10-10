package com.exercises.gameloftExercise.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MapKeyColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    private Integer cash;
    private Integer coins;

    @ElementCollection
    @MapKeyColumn(name = "item_name")
    @Column(name = "item_count")
    private Map<String, Integer> items;  // for items like "item_1": 1
}
