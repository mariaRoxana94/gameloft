package com.exercises.gameloftExercise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelMatcher {

    private Integer min;
    private Integer max;
}
