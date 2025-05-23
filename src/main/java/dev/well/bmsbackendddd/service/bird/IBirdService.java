package dev.well.bmsbackendddd.service.bird;

import dev.well.bmsbackendddd.dto.BirdDTO;

import java.util.Optional;

public interface IBirdService {
    Optional<BirdDTO> createAndSaveBird (BirdDTO birdDTO);
}
