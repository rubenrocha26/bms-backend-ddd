package dev.well.bmsbackendddd.domain.bird;

import dev.well.bmsbackendddd.ddd.AggregateRoot;
import dev.well.bmsbackendddd.domain.valueobject.*;

public class Bird implements AggregateRoot<BirdId> {
    private final BirdId _birdId;
    private final BirdScientificName _birdScientificName;
    private final BirdRing _birdRing;
    private final MutationId _mutationId;
    private BirdStatus _birdStatus;
    private final Date _birthDate;
    private Date _deathDate;

    //Bird Mutation can be null
    protected Bird (BirdId birdId, BirdScientificName birdScientificName, BirdRing birdRing, MutationId mutationId, Date birthDate) {
        if (birdId == null) throw new IllegalArgumentException("BirdId cannot be null");
        this._birdId = birdId;

        if (birdScientificName == null) throw new IllegalArgumentException("BirdScientificName cannot be null");
        this._birdScientificName = birdScientificName;

        if (birdRing == null) throw new IllegalArgumentException("BirdRing cannot be null");
        this._birdRing = birdRing;

        this._mutationId = mutationId;

        this._birdStatus = BirdStatus.ACTIVE;

        if (birthDate == null) throw new IllegalArgumentException("BirthDate cannot be null");
        this._birthDate = birthDate;
    }

    public void markAsDeath (Date  deathDate) {
        if (deathDate == null) throw new IllegalArgumentException("DeathDate cannot be null");
        this._deathDate = deathDate;
        this._birdStatus = BirdStatus.INACTIVE;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if(this == objectToCompare) return true;

        if(objectToCompare instanceof Bird bird) {
            return this._birdId.equals(bird._birdId);
        }
        return false;
    }

    @Override
    public boolean sameAs (Object objectToCompare) {
        if (objectToCompare instanceof Bird bird) {
            return (this._birdId.equals(bird._birdId) &&
                    this._birdScientificName.equals(bird._birdScientificName) &&
                    this._birdRing.equals(bird._birdRing) &&
                    java.util.Objects.equals(this._mutationId, bird._mutationId) &&
                    this._birdStatus.equals(bird._birdStatus) &&
                    this._birthDate.equals(bird._birthDate)) &&
                    java.util.Objects.equals(this._deathDate, bird._deathDate);
        }
        return false;
    }

    @Override
    public BirdId identity() {
        return this._birdId;
    }

    public BirdScientificName getBirdScientificName() {
        return this._birdScientificName;
    }

    public BirdRing getBirdRing() {
        return this._birdRing;
    }

    public MutationId getMutationId() {
        return this._mutationId;
    }

    public BirdStatus getBirdStatus() {
        return this._birdStatus;
    }

    public Date getBirthDate() {
        return this._birthDate;
    }
    public Date getDeathDate() {
        return this._deathDate;
    }
}
