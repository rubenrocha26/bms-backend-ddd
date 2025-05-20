package dev.well.bmsbackendddd.domain.valueobject;

import dev.well.bmsbackendddd.ddd.ValueObject;

public class BirdRing implements ValueObject {
    private String _birdRing;

    public  BirdRing (String birdRing) {
        if(birdRing == null || birdRing.isBlank()) throw new NullPointerException("BirdRing can't be null or blank");
        this._birdRing = birdRing;
    }
}
