package dev.well.bmsbackendddd.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MutationIdTest {
    @Test
    void shouldCreateMutationId() {
        //arrange
        String id = UUID.randomUUID().toString();
        //act
        MutationId mutationId = new MutationId(id);
        //assert
        assertNotNull(mutationId);
    }

    @Test
    void nullIdShouldThrowException() {
        //arrange
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new MutationId(null));
    }

    @Test
    void emptyIdShouldThrowException() {
        //arrange
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new MutationId(""));
    }

    @Test
    void testEquals() {
        //arrange
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        MutationId mutationId1 = new MutationId(id1);
        MutationId mutationId2 = new MutationId(id2);
        //act
        boolean result1 = mutationId1.equals(mutationId1);
        boolean result2 = mutationId1.equals(mutationId2);
        boolean result3 = mutationId1.equals(id1);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void shouldReturnStringId(){
        //arrange
        String id1 = UUID.randomUUID().toString();
        MutationId mutationId1 = new MutationId(id1);
        //act
        String result = mutationId1.toString();
        //assert
        assertEquals(id1, result);
    }

}