package dev.well.bmsbackendddd.persistence.dataModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bird")
public class BirdDataModel {
    @Id
    @Column(name="birdid")
    private String birdId;

    @Column(name="birdscientificname")
    private String birdScientificName;

    @Column(name="birdring")
    private String birdRing;

    @Column(name="mutationid")
    private String mutationId;

    @Column(name="birdstatus")
    private String birdStatus;

    @Column(name="birthdate")
    private String birthDate;

    @Column(name="deathdate")
    private String deathDate;

    public BirdDataModel() {}

    public BirdDataModel (String birdId, String birdScientificName, String birdRing, String mutationId, String birdStatus, String birthDate, String deathDate) {
        this.birdId = birdId;
        this.birdScientificName = birdScientificName;
        this.birdRing = birdRing;
        this.mutationId = mutationId;
        this.birdStatus = birdStatus;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public String getBirdId() {
        return this.birdId;
    }
    public String getBirdScientificName() {
        return this.birdScientificName;
    }
    public String getBirdRing() {
        return this.birdRing;
    }
    public String getMutationId() {
        return this.mutationId;
    }
    public String getBirdStatus() {
        return this.birdStatus;
    }
    public String getBirthDate() {
        return this.birthDate;
    }
    public String getDeathDate() {
        return this.deathDate;
    }
}
