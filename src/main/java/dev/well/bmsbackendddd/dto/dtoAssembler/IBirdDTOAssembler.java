package dev.well.bmsbackendddd.dto.dtoAssembler;

import dev.well.bmsbackendddd.domain.bird.Bird;

import dev.well.bmsbackendddd.dto.BirdDTO;

public interface IBirdDTOAssembler {

    BirdDTO toDTO (Bird bird, String description);
}
