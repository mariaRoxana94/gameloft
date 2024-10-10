package com.exercises.gameloftExercise.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDTO {
    private Long id;
    private String model;
    private String carrier;
    private String firmware;
}
