package dev.well.bmsbackendddd.service.mutation;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;

import java.util.Optional;

public interface IMutationService {
    public Optional<Mutation> createAndSaveMutation(Description description);

    public Optional<Mutation> getMutationById (MutationId mutationId);

    public Iterable<Mutation> getAllMutations();


}
