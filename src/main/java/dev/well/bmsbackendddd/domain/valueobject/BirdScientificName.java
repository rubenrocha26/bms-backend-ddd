package dev.well.bmsbackendddd.domain.valueobject;

import dev.well.bmsbackendddd.ddd.ValueObject;

public class BirdScientificName implements ValueObject {
    private final String _birdScientificName;

    public BirdScientificName (String birdScientificName) {
        if (birdScientificName == null || birdScientificName.isBlank()) {
            throw new NullPointerException("BirdScientificName can't be null or blank");
        }
        this._birdScientificName = birdScientificName;
    }

    @Override
    public String toString() {
        return this._birdScientificName;
    }
}
