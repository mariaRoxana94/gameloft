package com.exercises.gameloftExercise.mapppers;


import com.exercises.gameloftExercise.dto.DeviceDTO;
import com.exercises.gameloftExercise.entities.Device;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DeviceMapper {

    DeviceDTO fromDevice(Device device);

    Device fromDeviceDTO(DeviceDTO device);
}
