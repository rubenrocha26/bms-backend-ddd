package dev.well.bmsbackendddd.repository;

import dev.well.bmsbackendddd.ddd.IRepository;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;

public interface IMutationRepository extends IRepository<MutationId, Mutation> {

    boolean containsOfDescription(Description description);
}
