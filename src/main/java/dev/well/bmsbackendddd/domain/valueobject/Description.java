package dev.well.bmsbackendddd.domain.valueobject;

public class Description {
    private String _description;

    public Description (String description) {
        if(description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or empty");

        this._description = description;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if (this == objectToCompare) return true;

        if(objectToCompare instanceof Description descriptionToCompare) {
            return this._description.equals(descriptionToCompare._description);
        }
        return false;
    }

    @Override
    public String toString() {
        return this._description;
    }
}
