package dev.well.bmsbackendddd.service.mutation;

import dev.well.bmsbackendddd.dto.MutationDTO;
import dev.well.bmsbackendddd.dto.dtoAssembler.IMutationDTOAssembler;
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
    private final IMutationDTOAssembler _mutationDTOAssembler;

    public MutationServiceImpl (IMutationFactory mutationFactory, IMutationRepository mutationRepository, IMutationDTOAssembler mutationDTOAssembler) {
        if (mutationFactory == null) {
            throw new IllegalArgumentException("MutationFactory cannot be null");
        }
        if (mutationRepository == null) {
            throw new IllegalArgumentException("IMutationRepository cannot be null");
        }
        if (mutationDTOAssembler == null ) {
            throw new IllegalArgumentException("IMutationDTOAssembler cannot be null");
        }
        this._mutationFactory = mutationFactory;
        this._mutationRepository = mutationRepository;
        this._mutationDTOAssembler = mutationDTOAssembler;
    }

    @Override
    public Optional<MutationDTO> createAndSaveMutation (String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        try{
            Description domainDescription = new Description(description);
            boolean isMutationAlreadyRegistered = _mutationRepository.containsOfDescription(domainDescription);
            if (!isMutationAlreadyRegistered) {
                Mutation mutation = _mutationFactory.createMutation(domainDescription);
                _mutationRepository.save(mutation);
                return Optional.of(_mutationDTOAssembler.toDTO(mutation));
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
