package dev.well.bmsbackendddd.domain.mutation;

import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MutationFactoryImpl implements IMutationFactory{

    @Override
    public Mutation createMutation (Description description) {
        MutationId mutationId = new MutationId(UUID.randomUUID().toString());
        return new Mutation(mutationId, description);
    }

    @Override
    public Mutation createMutation (MutationId mutationId, Description description) {
        return new Mutation(mutationId, description);
    }
}
