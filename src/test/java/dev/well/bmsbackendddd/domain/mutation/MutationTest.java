package dev.well.bmsbackendddd.domain.mutation;

import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MutationTest {
    @Test
    void shouldCreateMutationWithValidParameters() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        //act
        Mutation mutation = new Mutation(mutationId, description);
        //assert
        assertNotNull( mutation );
    }

    @Test
    void nullIdShouldThrowException() {
        //arrange
        Description description = mock(Description.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Mutation(null, description));
    }

    @Test
    void nullDescriptionShouldThrowException() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Mutation(mutationId, null));
    }

    @Test
    void testEquals() {
        //arrange
        MutationId mutationId1 = mock(MutationId.class);
        Description description1 = mock(Description.class);
        MutationId mutationId2 = mock(MutationId.class);
        Description description2 = mock(Description.class);
        Mutation mutation = new Mutation(mutationId1, description1);
        Mutation mutation2 = new Mutation(mutationId1, description1);
        Mutation mutation3 = new Mutation(mutationId2, description2);
        //act
        boolean result1 = mutation.equals(mutation2);
        boolean result2 = mutation.equals(mutation3);
        boolean result3 = mutation.equals(mutation);
        boolean result4 = mutation.equals(mutationId1);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
    }

    @Test
    void identity() {
        //arrange
        MutationId mutationIdMock = mock(MutationId.class);
        Description description = mock(Description.class);
        Mutation mutation = new Mutation(mutationIdMock, description);
        //act
        MutationId mutationId1 = mutation.identity();
        //assert
        assertEquals(mutationIdMock, mutationId1);
    }

    @Test
    void sameAs() {
        //arrange
        MutationId mutationId1 = mock(MutationId.class);
        Description description1 = mock(Description.class);
        MutationId mutationId2 = mock(MutationId.class);
        Description description2 = mock(Description.class);
        Mutation mutation = new Mutation(mutationId1,  description1);
        Mutation mutation2 = new Mutation(mutationId2, description2);
        Mutation mutation3 = new Mutation(mutationId1, description1);
        Mutation mutation4 = new Mutation(mutationId2, description2);
        Mutation mutation5 = new Mutation(mutationId2, description1);
        Mutation mutation6 = new Mutation(mutationId1, description1);
        //act
        boolean result1 = mutation.sameAs(mutation2);
        boolean result4 = mutation.sameAs(mutation4);
        boolean result5 = mutation.sameAs(mutation5);
        boolean result6 = mutation.sameAs(mutation6);
        boolean result7 = mutation.sameAs(mutationId1);
        //assert
        assertFalse(result1);
        assertFalse(result4);
        assertFalse(result5);
        assertTrue(result6);
        assertFalse(result7);
    }

    @Test
    void shouldReturnTheDescription() {
        //arrange
        Description description = mock(Description.class);
        MutationId mutationId = mock(MutationId.class);
        Mutation mutation = new Mutation(mutationId, description);
        //act + assert
        assertEquals(description, mutation.getDescription());
    }

}