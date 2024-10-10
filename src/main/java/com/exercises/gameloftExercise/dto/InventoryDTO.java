package com.exercises.gameloftExercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDTO {
    private Integer cash;
    private Integer coins;

    private Map<String, Integer> items;
}
