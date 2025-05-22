package dev.well.bmsbackendddd.repository;

import dev.well.bmsbackendddd.ddd.IRepository;
import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.domain.valueobject.BirdId;
import dev.well.bmsbackendddd.domain.valueobject.BirdRing;

public interface IBirdRepository extends IRepository<BirdId, Bird> {
    boolean existsByBirdRing(BirdRing birdRing);
}
