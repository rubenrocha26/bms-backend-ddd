package dev.well.bmsbackendddd.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {

    @Test
    void shouldCreateDescriptionWithValidValue() {
        //arrange
        String description = "This is a description";
        //act
        Description descriptionObject = new Description(description);
        //assert
        assertNotNull(descriptionObject);
    }
    @Test
    void shouldThrowExceptionWhenParameterIsNull() {
        //arrange
        String description = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Description(description));
    }

    @Test
    void shouldThrowExceptionWhenParameterIsEmpty() {
        //arrange
        String description = "";
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Description(description));
    }

    @Test
    void testEquals() {
        //arrange
        String description1 = "This is a description";
        String description2 = "This is another description";
        Description descriptionObject1 = new Description(description1);
        Description descriptionObject2 = new Description(description2);
        Description descriptionObject3 = new Description(description1);
        //act
        boolean result1 = descriptionObject1.equals(descriptionObject1);
        boolean result2 = descriptionObject1.equals(descriptionObject2);
        boolean result3 = descriptionObject1.equals(description1);
        boolean result4 = descriptionObject1.equals(descriptionObject3);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
    }

    @Test
    void testToString() {
        //arrange
        String description1 = "This is a description";
        Description descriptionObject = new Description(description1);
        //act
        String result1 = descriptionObject.toString();
        //assert
        assertEquals(description1, result1);
    }
}