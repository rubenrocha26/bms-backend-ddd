package dev.well.bmsbackendddd.dto;

public class MutationDTO {
    private final String mutationId;
    private final String description;

    public MutationDTO(String mutationId, String description) {
        if(mutationId == null || mutationId.isBlank()){
            throw new IllegalArgumentException("MutationId cannot be null or blank");
        }
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
