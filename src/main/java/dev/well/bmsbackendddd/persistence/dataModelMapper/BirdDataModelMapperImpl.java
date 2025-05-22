package dev.well.bmsbackendddd.persistence.dataModelMapper;

import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.domain.bird.IBirdFactory;
import dev.well.bmsbackendddd.domain.valueobject.*;
import dev.well.bmsbackendddd.persistence.dataModel.BirdDataModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BirdDataModelMapperImpl implements IBirdDataModelMapper {
    private final IBirdFactory _birdFactory;

    public BirdDataModelMapperImpl(IBirdFactory birdFactory) {
        if(birdFactory == null) throw new NullPointerException("BirdFactory can't be null");
        this._birdFactory = birdFactory;
    }

    @Override
    public Bird toDomain(BirdDataModel birdDataModel) {
        BirdId birdId = new BirdId(birdDataModel.getBirdId());
        BirdScientificName birdScientificName = new BirdScientificName(birdDataModel.getBirdScientificName());
        BirdRing birdRing = new BirdRing(birdDataModel.getBirdRing());
        MutationId mutationId = new MutationId(birdDataModel.getMutationId());
        Date birthDate = new Date(LocalDate.parse(birdDataModel.getBirthDate()));

        if (birdDataModel.getDeathDate() != null) {
            Date deathDate = new Date(LocalDate.parse(birdDataModel.getDeathDate()));
            return _birdFactory.createDeathBird(birdId, birdScientificName, birdRing, mutationId, birthDate, deathDate);
        } else {
            return _birdFactory.createBird(birdId, birdScientificName, birdRing, mutationId, birthDate);
        }
    }

    @Override
    public Iterable<Bird> toDomain(Iterable<BirdDataModel> birdDataModels) {
        List<Bird>  birds = new ArrayList<>();

        birdDataModels.forEach(birdDataModel -> {
            birds.add(toDomain(birdDataModel));
        });
        return birds;
    }

    @Override
    public BirdDataModel toDataModel(Bird bird) {
        String birdId = bird.identity().toString();
        String birdScientificName = bird.getBirdScientificName().toString();
        String birdRing = bird.getBirdRing().toString();
        String mutationId = bird.getMutationId().toString();
        String birdStatus = bird.getBirdStatus().toString();
        String birthDate = bird.getBirthDate().toString();
        String deathDate = bird.getDeathDate().toString();

        return  new BirdDataModel(birdId, birdScientificName, birdRing, mutationId, birdStatus, birthDate, deathDate);
    }
}
