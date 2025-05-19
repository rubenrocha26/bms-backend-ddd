package dev.well.bmsbackendddd.persistence.dataModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="mutation")
public class MutationDataModel {
    @Id
    @Column(name="mutationid")
    private String mutationId;
    @Column(name="description")
    private String description;

    public MutationDataModel() {}

    public MutationDataModel(String mutationId, String mutationDescription) {
        if(mutationId == null || mutationDescription == null) {
            throw new IllegalArgumentException("Parameters for DataModel cannot be null");
        }
        this.mutationId = mutationId;
        this.description = mutationDescription;
    }

    public String getMutationId() {
        return this.mutationId;
    }

    public String getDescription() {
        return this.description;
    }
}
