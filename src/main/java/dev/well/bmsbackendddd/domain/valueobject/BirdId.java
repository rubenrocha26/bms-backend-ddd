package dev.well.bmsbackendddd.domain.valueobject;

import dev.well.bmsbackendddd.ddd.DomainId;

public class BirdId implements DomainId {
    private final String _birdId;

    public BirdId (String birdId) {
        if (birdId==null || birdId.isBlank()) throw new NullPointerException("BirdId can't be null or blank");
        this._birdId = birdId;
    }

    @Override
    public String toString () {return this._birdId;}
}
