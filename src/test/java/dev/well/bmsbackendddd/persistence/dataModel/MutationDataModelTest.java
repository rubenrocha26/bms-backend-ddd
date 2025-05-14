package dev.well.bmsbackendddd.persistence.dataModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutationDataModelTest {

    @Test
    void shouldCreateMutationDataModel() {
        //arrange
        //act
        MutationDataModel mutationDataModel = new MutationDataModel();
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void shouldCreateMutationDataModelFromDomain() {
        //arrange
        String mutationId = "mutationId";
        String description = "description";
        //act
        MutationDataModel mutationDataModel = new MutationDataModel(mutationId, description);
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void shouldReturnMutationId(){
        //arrange
        String mutationId = "mutationId";
        String description = "description";
        MutationDataModel mutationDataModel = new MutationDataModel(mutationId, description);
        //act
        String result = mutationDataModel.getMutationId();
        //assert
        assertEquals("mutationId", result);
    }

    @Test
    void shouldReturnDescription(){
        //arrange
        String mutationId = "mutationId";
        String description = "description";
        MutationDataModel mutationDataModel = new MutationDataModel(mutationId, description);
        //act
        String result = mutationDataModel.getDescription();
        //assert
        assertEquals("description", result);
    }

}