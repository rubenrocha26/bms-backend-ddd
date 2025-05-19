package dev.well.bmsbackendddd.dto;

public class MutationDto {

    private final String mutationId;
    private final String mutationDescription;

    public MutationDto(String mutationId, String mutationDescription) {
        if (mutationId == null || mutationId.isBlank()) {
            throw new IllegalArgumentException("MutationId cannot be null or blank");
        }
        if (mutationDescription == null || mutationDescription.isBlank()) {
            throw new IllegalArgumentException("MutationDescription cannot be null or blank");
        }
        this.mutationId = mutationId;
        this.mutationDescription = mutationDescription;
    }

    public String getMutationId() {
        return mutationId;
    }
    public String getDescription() {
        return mutationDescription;
    }
}
