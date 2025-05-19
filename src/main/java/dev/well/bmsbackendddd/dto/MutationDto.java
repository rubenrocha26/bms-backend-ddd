package dev.well.bmsbackendddd.dto;

public class MutationDto {
    private final String mutationId;
    private final String description;

    public MutationDto(String mutationId, String description) {
        if (description == null) {
            throw new IllegalArgumentException("MutationDescription cannot be null or blank");
        }
        this.mutationId = mutationId;
        this.description = description;
    }

    public String getMutationId() {
        return mutationId;
    }
    public String getDescription() {
        return description;
    }
}
