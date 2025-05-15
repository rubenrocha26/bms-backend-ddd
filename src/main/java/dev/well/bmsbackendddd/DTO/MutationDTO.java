package dev.well.bmsbackendddd.DTO;

public class MutationDTO {

    private final String _mutationId;
    private final String _mutationDescription;

    public MutationDTO (String mutationId, String mutationDescription) {
        if (mutationId == null || mutationId.isBlank()) {
            throw new IllegalArgumentException("MutationId cannot be null or blank");
        }
        if (mutationDescription == null || mutationDescription.isBlank()) {
            throw new IllegalArgumentException("MutationDescription cannot be null or blank");
        }
        this._mutationId = mutationId;
        this._mutationDescription = mutationDescription;
    }

    public String getMutationId() {
        return _mutationId;
    }
    public String getDescription() {
        return _mutationDescription;
    }
}
