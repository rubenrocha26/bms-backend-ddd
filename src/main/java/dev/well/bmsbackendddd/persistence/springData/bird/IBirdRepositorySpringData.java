package dev.well.bmsbackendddd.persistence.springData.bird;

import dev.well.bmsbackendddd.persistence.dataModel.BirdDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBirdRepositorySpringData extends JpaRepository<BirdDataModel, String> {
    boolean existsByBirdRing(String birdRing);
}
