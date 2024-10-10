package com.exercises.gameloftExercise;


import com.exercises.gameloftExercise.dto.ClanDTO;
import com.exercises.gameloftExercise.dto.DeviceDTO;
import com.exercises.gameloftExercise.dto.InventoryDTO;
import com.exercises.gameloftExercise.dto.PlayerProfileDTO;
import com.exercises.gameloftExercise.mapppers.DeviceMapper;
import com.exercises.gameloftExercise.mapppers.PlayerProfileMapper;
import com.exercises.gameloftExercise.repositories.DeviceRepository;
import com.exercises.gameloftExercise.repositories.PlayerProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner init(PlayerProfileRepository playerProfileRepository, DeviceRepository deviceRepository,
                                  PlayerProfileMapper playerMapper, DeviceMapper deviceMapper) {
        return args -> {
            DeviceDTO deviceDTO = DeviceDTO.builder()
                    .model("apple iphone 11")
                    .carrier("vodafone")
                    .firmware("123")
                    .build();

            // init device
            if (deviceRepository.count() == 0) {
                deviceRepository.save(deviceMapper.fromDeviceDTO(deviceDTO));
            }

            // init playerProfile
            if (playerProfileRepository.count() == 0) {
                Map<String, Integer> items = new HashMap<>(3);
                items.put("item_1", 1);
                items.put("item_34", 3);
                items.put("item_55", 2);

                InventoryDTO inventoryDTO = InventoryDTO.builder()
                        .cash(123)
                        .coins(123)
                        .items(items)
                        .build();

                ClanDTO clanDTO = ClanDTO.builder()
                        .id("12345")
                        .name("Hello world clan")
                        .build();

                PlayerProfileDTO playerProfileDTO = PlayerProfileDTO.builder()
                        .credential("apple_credential")
                        .created(ZonedDateTime.parse("2021-01-10 13:37:17Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                        .modified(ZonedDateTime.parse("2021-01-23 13:37:17Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                        .lastSession(ZonedDateTime.parse("2021-01-23 13:37:17Z",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                        .totalSpent(400)
                        .totalRefund(0)
                        .totalTransactions(5)
                        .lastPurchase(ZonedDateTime.parse("2021-01-22 13:37:17Z",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                        .activeCampaigns(List.of())
                        .devices(List.of(deviceDTO))
                        .level(3)
                        .xp(1000)
                        .totalPlaytime(144)
                        .country("CA")
                        .language("fr")
                        .birthdate(ZonedDateTime.parse("2000-01-10 13:37:17Z", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX")))
                        .gender("male")
                        .inventory(inventoryDTO)
                        .clan(clanDTO)
                        .customfield("mycustom")
                        .build();
                playerProfileRepository.save(playerMapper.fromPlayerDTO(playerProfileDTO));

            }
        };
    }
}
