package dev.well.bmsbackendddd.persistence.springData.bird;

import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.domain.valueobject.BirdId;
import dev.well.bmsbackendddd.domain.valueobject.BirdRing;
import dev.well.bmsbackendddd.persistence.dataModel.BirdDataModel;
import dev.well.bmsbackendddd.persistence.dataModelMapper.IBirdDataModelMapper;
import dev.well.bmsbackendddd.repository.IBirdRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BirdRepositorySpringData implements IBirdRepository {
    private  final IBirdRepositorySpringData _birdRepositorySpringData;
    private final IBirdDataModelMapper _birdDataModelMapper;

    public BirdRepositorySpringData (IBirdRepositorySpringData birdRepositorySpringData, IBirdDataModelMapper birdDataModelMapper) {
        if(birdRepositorySpringData == null){
            throw  new IllegalArgumentException("BirdRepositorySpringData cannot be null");
        }
        if(birdDataModelMapper == null){
            throw new IllegalArgumentException("BirdDataModelMapper cannot be null");
        }

        this._birdRepositorySpringData = birdRepositorySpringData;
        this._birdDataModelMapper = birdDataModelMapper;
    }


    @Override
    public Bird save(Bird bird) {
        if(bird == null){
            throw new IllegalArgumentException("Bird cannot be null");
        }

        _birdRepositorySpringData.save(_birdDataModelMapper.toDataModel(bird));

        return  bird;
    }

    @Override
    public Iterable<Bird> findAll() {
        List<BirdDataModel> birdDataModels = _birdRepositorySpringData.findAll();

        return _birdDataModelMapper.toDomain(birdDataModels);
    }

    @Override
    public Optional<Bird> ofIdentity (BirdId birdId) {
        if (birdId == null) {
            throw new IllegalArgumentException("BirdId cannot be null");
        }
        Optional<BirdDataModel> birdDataModelFromRepository = _birdRepositorySpringData.findById(birdId.toString());

        //if present return Optional of Mutation, else return Optional Empty
        return birdDataModelFromRepository.map(_birdDataModelMapper::toDomain);
    }

    @Override
    public boolean containsOfIdentity(BirdId birdId) {
        if (birdId == null) {
            throw new IllegalArgumentException("BirdId cannot be null");
        }
        return _birdRepositorySpringData.existsById(birdId.toString());
    }

    @Override
    public boolean existsByBirdRing(BirdRing birdRing) {
        if (birdRing == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        return _birdRepositorySpringData.existsByBirdRing(birdRing.toString());
    }
}
