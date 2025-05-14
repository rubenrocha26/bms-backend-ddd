package dev.well.bmsbackendddd.domain.mutation;

import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;

class MutationFactoryImplTest {

    @Test
    void givenMockedConstructorMutationFactoryShouldCreateMutation() {
        //arrange
        MutationFactoryImpl mutationFactoryImpl = new MutationFactoryImpl();
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        try (MockedConstruction<Mutation> mockMutation = mockConstruction(Mutation.class, (mock, context) ->{
        })) {
            //act
            Mutation mutation = mutationFactoryImpl.createMutation(mutationId, description);
            //assert
            assertNotNull(mutation);

            //O objeto isolado deve existir
            assertEquals(1, mockMutation.constructed().size());
            Mutation doubleMutation = mockMutation.constructed().get(0);
            assertNotNull(doubleMutation);
            assertEquals(mutation,doubleMutation);
        }
    }

    @Test
    void mockingConstructorThrowingException(){
        //arrange
        MutationFactoryImpl mutationFactoryImpl = new MutationFactoryImpl();
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        //Use try-with-resources to mock construction and throw an exception
        try (MockedConstruction<Mutation> mock = mockConstruction(Mutation.class,(mocked, context) ->
        {
            //Define behavior: throwing an exception when a new instance of Location is created
            throw new RuntimeException(new InstantiationException("Mutation constructor failed"));
        })) {
            //Act: trying to create accessMethod will throw the exception
            try {
                mutationFactoryImpl.createMutation (mutationId, description);
                fail("Expect exception not thrown");
            } catch (Exception e) {
                //Assertion to check if the exception is thrown
                assertTrue(e.getCause().getMessage().contains("Mutation constructor failed"));
            }
        }
    }

    @Test
    void givenMockedConstructorMutationFactoryShouldCreateMutationWithDescription() {
        //arrange
        MutationFactoryImpl mutationFactoryImpl = new MutationFactoryImpl();
        Description description = mock(Description.class);
        try (MockedConstruction<Mutation> mockMutation = mockConstruction(Mutation.class, (mock, context) ->{
        })) {
            //act
            Mutation mutation = mutationFactoryImpl.createMutation(description);
            //assert
            assertNotNull(mutation);

            //O objeto isolado deve existir
            assertEquals(1, mockMutation.constructed().size());
            Mutation doubleMutation = mockMutation.constructed().get(0);
            assertNotNull(doubleMutation);
            assertEquals(mutation,doubleMutation);
        }
    }

    @Test
    void mockingConstructorWithDescriptionThrowingException() {
        //arrange
        MutationFactoryImpl mutationFactoryImpl = new MutationFactoryImpl();
        Description description = mock(Description.class);
        //Use try-with-resources to mock construction and throw an exception
        try (MockedConstruction<Mutation> mock = mockConstruction(Mutation.class, (mocked, context) ->
        {
            //Define behavior: throwing an exception when a new instance of Location is created
            throw new RuntimeException(new InstantiationException("Mutation constructor failed"));
        })) {
            //Act: trying to create accessMethod will throw the exception
            try {
                mutationFactoryImpl.createMutation(description);
                fail("Expect exception not thrown");
            } catch (Exception e) {
                //Assertion to check if the exception is thrown
                assertTrue(e.getCause().getMessage().contains("Mutation constructor failed"));
            }
        }
    }

}