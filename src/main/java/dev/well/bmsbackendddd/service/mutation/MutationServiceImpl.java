package dev.well.bmsbackendddd.service.mutation;

import dev.well.bmsbackendddd.dto.dtoMapper.IMutationDtoMapper;
import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.repository.IMutationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutationServiceImpl implements IMutationService {
    private final IMutationFactory _mutationFactory;
    private final IMutationRepository _mutationRepository;

    public MutationServiceImpl (IMutationFactory mutationFactory, IMutationRepository _mutationRepository, IMutationDtoMapper mutationDTOMapper) {
        if (mutationFactory == null) {
            throw new IllegalArgumentException("MutationFactory cannot be null");
        }
        if (_mutationRepository == null) {
            throw new IllegalArgumentException("IMutationRepository cannot be null");
        }
        this._mutationFactory = mutationFactory;
        this._mutationRepository = _mutationRepository;
    }

    @Override
    public Optional<Mutation> createAndSaveMutation (Description description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        try{
            boolean isMutationAlreadyRegistered = _mutationRepository.containsOfDescription(description);
            if (!isMutationAlreadyRegistered) {
                Mutation mutation = _mutationFactory.createMutation(description);
                return Optional.of(_mutationRepository.save(mutation));
            }
            return Optional.empty();
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Mutation> getMutationById (MutationId mutationId) {
        if (mutationId == null) {
            throw new IllegalArgumentException("MutationId cannot be null");
        }

        return _mutationRepository.ofIdentity(mutationId);
    }

    @Override
    public Iterable<Mutation> getAllMutations() {
        return _mutationRepository.findAll();
    }

}
