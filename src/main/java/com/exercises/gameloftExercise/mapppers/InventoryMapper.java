package com.exercises.gameloftExercise.mapppers;


import com.exercises.gameloftExercise.dto.InventoryDTO;
import com.exercises.gameloftExercise.entities.Inventory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InventoryMapper {

    InventoryDTO fromInventory(Inventory inventory);
    Inventory fromInventoryDTO(InventoryDTO inventory);
}
