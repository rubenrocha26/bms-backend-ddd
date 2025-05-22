package dev.well.bmsbackendddd.domain.bird;

import dev.well.bmsbackendddd.domain.valueobject.*;

public interface IBirdFactory {
    Bird createBird (BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate);

    Bird createBird (BirdId birdId, BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate);

}
