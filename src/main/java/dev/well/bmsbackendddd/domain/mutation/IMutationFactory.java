package dev.well.bmsbackendddd.domain.mutation;

import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;

public interface IMutationFactory {
    Mutation createMutation(Description description);

    Mutation createMutation(MutationId mutationId, Description description);
}
