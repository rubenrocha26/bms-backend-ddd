package dev.well.bmsbackendddd.persistence.dataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="mutation")
public class MutationDataModel {
    @Id
    private String mutationId;
    private String mutationDescription;

    public MutationDataModel() {}

    public MutationDataModel(String mutationId, String mutationDescription) {
        if(mutationId == null || mutationDescription == null) {
            throw new IllegalArgumentException("Parameters for DataModel cannot be null");
        }
        this.mutationId = mutationId;
        this.mutationDescription = mutationDescription;
    }

    public String getMutationId() {
        return this.mutationId;
    }

    public String getDescription() {
        return this.mutationDescription;
    }
}
