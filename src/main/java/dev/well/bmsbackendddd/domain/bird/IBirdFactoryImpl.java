package dev.well.bmsbackendddd.domain.bird;

import dev.well.bmsbackendddd.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IBirdFactoryImpl implements IBirdFactory {

    public Bird createBird (BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate) {
        BirdId birdId = new BirdId(UUID.randomUUID().toString());
        return new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
    }

    public Bird createBird (BirdId birdId, BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate){
        return new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
    }

    @Override
    public Bird createDeathBird (BirdId birdId, BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate, Date deathDate){
        Bird bird = new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
        bird.markAsDeath(deathDate);
        return bird;
    }


}
