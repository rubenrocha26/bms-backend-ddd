package dev.well.bmsbackendddd.service.mutation;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.dto.MutationDTO;

import java.util.Optional;

public interface IMutationService {
    public Optional<MutationDTO> createAndSaveMutation(String description);

    public Optional<Mutation> getMutationById (MutationId mutationId);

    public Iterable<Mutation> getAllMutations();


}
