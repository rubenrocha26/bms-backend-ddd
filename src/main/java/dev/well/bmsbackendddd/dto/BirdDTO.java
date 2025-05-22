package dev.well.bmsbackendddd.dto;

public class BirdDTO {
    private final String birdId;
    private final String birdScientificName;
    private final String birdRing;
    private final String mutationId;
    private final String mutationDescription;
    private final String birdStatus;
    private final String birthDate;
    private final String deathDate;

    public BirdDTO (String birdId, String birdScientificName, String birdRing, String mutationId, String mutationDescription, String birdStatus, String birthDate, String deathDate) {
        if (birdId == null) {
            throw new IllegalArgumentException("BirdId cannot be null");
        }
        this.birdId = birdId;
        if (birdScientificName == null) {
            throw new IllegalArgumentException("BirdScientificName cannot be null");
        }
        this.birdScientificName = birdScientificName;
        if (birdRing == null) {
            throw new IllegalArgumentException("BirdRing cannot be null");
        }
        this.birdRing = birdRing;
        this.mutationId = mutationId;
        this.mutationDescription = mutationDescription;
        if (birdStatus == null) {
            throw new IllegalArgumentException("BirdStatus cannot be null");
        }
        this.birdStatus = birdStatus;
        if (birthDate == null) {
            throw new IllegalArgumentException("BirthDate cannot be null");
        }
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public String getBirdId() {
        return birdId;
    }
    public String getBirdScientificName() {
        return birdScientificName;
    }
    public String getBirdRing() {
        return birdRing;
    }
    public String getMutationId() {
        return mutationId;
    }
    public String getMutationDescription() {
        return mutationDescription;
    }
    public String getBirdStatus() {
        return birdStatus;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getDeathDate() {
        return deathDate;
    }
}
