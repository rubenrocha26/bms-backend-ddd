package dev.well.bmsbackendddd.controller;

import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.mutation.MutationFactoryImpl;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.dto.MutationDto;
import dev.well.bmsbackendddd.dto.dtoMapper.IMutationDtoMapper;
import dev.well.bmsbackendddd.dto.dtoMapper.MutationDtoMapperImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutationControllerTest {

    @Test
    void testMutationToDtoConversion_ShouldReturnCorrectDescription() {
        // Arrange
        String expectedDescription = "Classico";
        Description description = new Description(expectedDescription);
        IMutationFactory mutationFactory = new MutationFactoryImpl();
        Mutation mutation = mutationFactory.createMutation(description);

        // Criar instância do mapper com mock do factory
        IMutationDtoMapper mapper = new MutationDtoMapperImpl(mutationFactory);

        // Act
        MutationDto dto = mapper.toDTO(mutation);

        // Assert
        assertEquals(expectedDescription, dto.getDescription());
    }

}