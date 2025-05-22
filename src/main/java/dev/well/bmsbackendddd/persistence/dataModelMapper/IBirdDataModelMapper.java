package dev.well.bmsbackendddd.persistence.dataModelMapper;

import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.persistence.dataModel.BirdDataModel;

public interface IBirdDataModelMapper {

    Bird toDomain (BirdDataModel birdDataModel);

    Iterable<Bird> toDomain (Iterable<BirdDataModel> birdDataModels);

    BirdDataModel toDataModel (Bird bird);
}
