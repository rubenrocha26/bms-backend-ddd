package dev.well.bmsbackendddd.persistence.springData.mutation;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.persistence.dataModelMapper.IMutationDataModelMapper;
import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;
import dev.well.bmsbackendddd.repository.IMutationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MutationRepositorySpringDataImpl implements IMutationRepository {
    private final IMutationRepositorySpringData _mutationRepositorySpringData;
    private final IMutationDataModelMapper _mutationDataModelMapper;

    public MutationRepositorySpringDataImpl (IMutationRepositorySpringData mutationRepositorySpringData, IMutationDataModelMapper mutationDataModelMapper) {
        if(mutationRepositorySpringData == null){
            throw new IllegalArgumentException("MutationRepositorySpringData cannot be null");
        }
        if(mutationDataModelMapper == null){
            throw new IllegalArgumentException("MutationDataModelMapper cannot be null");
        }
        this._mutationRepositorySpringData = mutationRepositorySpringData;
        this._mutationDataModelMapper = mutationDataModelMapper;
    }
    @Override
    public Mutation save (Mutation mutation) {
        if(mutation == null){
            throw new IllegalArgumentException("Mutation cannot be null");
        }

        _mutationRepositorySpringData.save(_mutationDataModelMapper.toDataModel(mutation));

        return  mutation;
    }

    @Override
    public Iterable<Mutation> findAll() {
        List<MutationDataModel> mutationDataModels = _mutationRepositorySpringData.findAll();

        return _mutationDataModelMapper.toDomain(mutationDataModels);
    }

    @Override
    public Optional<Mutation> ofIdentity (MutationId mutationId) {
        if (mutationId == null) {
            throw new IllegalArgumentException("MutationId cannot be null");
        }
        Optional<MutationDataModel> mutationDataModelFromRepository = _mutationRepositorySpringData.findById(mutationId.toString());

        //if present return Optional of Mutation, else return Optional Empty
        return mutationDataModelFromRepository.map(_mutationDataModelMapper::toDomain);

    }

    @Override
    public boolean containsOfIdentity (MutationId mutationId) {
        if (mutationId == null) {
            throw new IllegalArgumentException("MutationId cannot be null");
        }
        return _mutationRepositorySpringData.existsById(mutationId.toString());
    }

    @Override
    public boolean containsOfDescription (Description description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        return _mutationRepositorySpringData.existsByDescription(description.toString());
    }

    @Override
    public String getDescriptionByMutationId (MutationId mutationId) {
        if (mutationId == null) {
            throw new IllegalArgumentException("MutationId cannot be null");
        }
        Optional<MutationDataModel> mutationDataModelFromRepository = _mutationRepositorySpringData.findById(mutationId.toString());
        return mutationDataModelFromRepository.get().getDescription();
    }
}
