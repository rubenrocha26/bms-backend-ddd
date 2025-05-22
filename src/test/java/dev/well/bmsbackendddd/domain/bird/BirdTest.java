package dev.well.bmsbackendddd.domain.bird;

import dev.well.bmsbackendddd.domain.valueobject.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BirdTest {

    @Test
    void shouldCreateBirdWithoutMutation() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = null;
        Date birthDate = mock(Date.class);
        //act
        Bird bird = new Bird(birdId, birdScientificName, birdRing, null, birthDate);
        //assert
        assertNotNull(bird);
    }

    @Test
    void shouldCreateBirdWithMutation() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act
        Bird bird = new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
        //assert
        assertNotNull(bird);
    }

    @Test
    void nullBirdIdThrowsException() {
        //arrange
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Bird(null, birdScientificName, birdRing, mutationId, birthDate));
    }

    @Test
    void nullBirdScientificNameThrowsException() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Bird(birdId, null, birdRing, mutationId, birthDate));
    }

    @Test
    void nullBirdRingThrowsException() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Bird(birdId, birdScientificName, null, mutationId, birthDate));
    }

    @Test
    void nullBirthDateThrowsException() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Bird(birdId, birdScientificName, birdRing, mutationId, null));
    }

    @Test
    void shouldSetBirdToInactive(){
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        Bird bird = new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
        Date deathDate = mock(Date.class);
        //act
        bird.markAsDeath(deathDate);
        //assert
        assertEquals(BirdStatus.INACTIVE, bird.getBirdStatus());
    }

    @Test
    void shouldThrowExceptionIfDeathDateisNull() {
        BirdId birdId = mock(BirdId.class);
        BirdScientificName birdScientificName = mock(BirdScientificName.class);
        BirdRing birdRing = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        Bird bird = new Bird(birdId, birdScientificName, birdRing, mutationId, birthDate);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> bird.markAsDeath(null));
    }

    @Test
    void equalsShouldReturnTrueForSameObject() {
        //arrange
        BirdId birdId = mock(BirdId.class);
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act
        Bird bird = new Bird(birdId, name, ring, mutationId, birthDate);
        //assert
        assertTrue(bird.equals(bird));
    }

    @Test
    void equalsShouldReturnTrueForObjectsWithSameBirdId() {
        //arrange
        BirdId birdId = new BirdId("id-1");

        BirdScientificName name1 = mock(BirdScientificName.class);
        BirdRing ring1 = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate1 = mock(Date.class);

        BirdScientificName name2 = mock(BirdScientificName.class);
        BirdRing ring2 = mock(BirdRing.class);
        MutationId mutationId2 = mock(MutationId.class);
        Date birthDate2 = mock(Date.class);

        Bird bird1 = new Bird(birdId, name1, ring1, mutationId1, birthDate1);
        Bird bird2 = new Bird(birdId, name2, ring2, mutationId2, birthDate2);

        //act + asser
        assertTrue(bird1.equals(bird2));
    }

    @Test
    void equalsShouldReturnFalseForObjectsWithDifferentBirdId() {
        //arrange
        BirdId birdId1 = new BirdId("id-1");
        BirdId birdId2 = new BirdId("id-2");

        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);

        Bird bird1 = new Bird(birdId1, name, ring, mutationId, birthDate);
        Bird bird2 = new Bird(birdId2, name, ring, mutationId, birthDate);

        //act + assert
        assertFalse(bird1.equals(bird2));
    }

    @Test
    void shouldReturnFalseIfComparedWithOtherObject(){
        //arrange
        BirdId birdId = new BirdId("id-1");

        BirdScientificName name1 = mock(BirdScientificName.class);
        BirdRing ring1 = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate1 = mock(Date.class);

        Bird bird1 = new Bird(birdId, name1, ring1, mutationId1, birthDate1);
        String test = "test";
        //act + assert
        assertFalse(test.equals(bird1));
    }

    @Test
    void sameAsShouldReturnTrueForBirdsWithSameAttributes() {
        //arrange
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);

        Bird bird1 = new Bird(birdId, name, ring, mutationId, birthDate);
        Bird bird2 = new Bird(birdId, name, ring, mutationId, birthDate);
        //act + assert
        assertTrue(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseForBirdsWithDifferentAttributes() {
        //arrange
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name1 = mock(BirdScientificName.class);
        BirdRing ring1 = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate1 = mock(Date.class);

        BirdId birdId2 = new BirdId("id-2");
        BirdScientificName name2 = mock(BirdScientificName.class);
        BirdRing ring2 = mock(BirdRing.class);
        MutationId mutationId2 = mock(MutationId.class);
        Date birthDate2 = mock(Date.class);

        Bird bird1 = new Bird(birdId, name1, ring1, mutationId1, birthDate1);
        Bird bird2 = new Bird(birdId2, name2, ring2, mutationId2, birthDate2);
        //act + assert
        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseWhenComparingWithNonBirdObject() {
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);

        Bird bird = new Bird(birdId, name, ring, mutationId, birthDate);

        assertFalse(bird.sameAs("not a bird"));
    }

    @Test
    void sameAsShouldReturnFalseWhenBirdScientificNameDiffers(){
        //arrange
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name1 = mock(BirdScientificName.class);
        BirdScientificName name2 = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act
        Bird bird1 = new Bird(birdId, name1, ring, mutationId1, birthDate);
        Bird bird2 = new Bird(birdId, name2, ring, mutationId1, birthDate);
        //assert
        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseWhenBirdRingDiffers(){
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name1 = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        BirdRing ring2 = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        //act
        Bird bird1 = new Bird(birdId, name1, ring, mutationId1, birthDate);
        Bird bird2 = new Bird(birdId, name1, ring2, mutationId1, birthDate);
        //assert
        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseWhenMutationIdDiffers() {
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        MutationId mutationId2 = mock(MutationId.class);
        Date birthDate = mock(Date.class);

        Bird bird1 = new Bird(birdId, name, ring, mutationId1, birthDate);
        Bird bird2 = new Bird(birdId, name, ring, mutationId2, birthDate);

        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseWhenDeathDateDiffers() {
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);

        Bird bird1 = new Bird(birdId, name, ring, mutationId, birthDate);
        Bird bird2 = new Bird(birdId, name, ring, mutationId, birthDate);

        Date deathDate = mock(Date.class);
        bird1.markAsDeath(deathDate);

        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnFalseWhenBirthDateDiffers() {
        //arrange
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId1 = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        Date birthDate2 = mock(Date.class);
        //act
        Bird bird1 = new Bird(birdId, name, ring, mutationId1, birthDate);
        Bird bird2 = new Bird(birdId, name, ring, mutationId1, birthDate2);
        //assert
        assertFalse(bird1.sameAs(bird2));
    }

    @Test
    void sameAsShouldReturnTrueWhenAllFieldsIncludingDeathDateAreEqual() {
        BirdId birdId = new BirdId("id-1");
        BirdScientificName name = mock(BirdScientificName.class);
        BirdRing ring = mock(BirdRing.class);
        MutationId mutationId = mock(MutationId.class);
        Date birthDate = mock(Date.class);
        Date deathDate = mock(Date.class);

        Bird bird1 = new Bird(birdId, name, ring, mutationId, birthDate);
        Bird bird2 = new Bird(birdId, name, ring, mutationId, birthDate);

        bird1.markAsDeath(deathDate);
        bird2.markAsDeath(deathDate);

        assertTrue(bird1.sameAs(bird2));
    }


}