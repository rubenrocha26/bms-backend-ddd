package dev.well.bmsbackendddd.domain.mutation;

import dev.well.bmsbackendddd.ddd.AggregateRoot;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;

public class Mutation implements AggregateRoot<MutationId> {
    private MutationId _mutationId;
    private Description _mutationDescription;

    protected Mutation (MutationId mutationId, Description description) {
        if (mutationId == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this._mutationId = mutationId;

        if(description == null) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        this._mutationDescription = description;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if(this == objectToCompare) return true;

        if(objectToCompare instanceof Mutation mutation) {
            return this._mutationId.equals(mutation._mutationId);
        }
        return false;
    }

    @Override
    public MutationId identity() {
        return this._mutationId;
    }

    @Override
    public boolean sameAs (Object objectToCompare){
        if (objectToCompare instanceof Mutation mutation) {
            return this._mutationId.equals(mutation._mutationId) && this._mutationDescription.equals(mutation._mutationDescription);
        }
        return false;
    }

    public Description getDescription() {
        return _mutationDescription;
    }
}
