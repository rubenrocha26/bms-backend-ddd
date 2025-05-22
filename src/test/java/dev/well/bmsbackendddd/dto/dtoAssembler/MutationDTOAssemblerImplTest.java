package dev.well.bmsbackendddd.dto.dtoAssembler;

import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.mutation.MutationFactoryImpl;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.dto.MutationDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MutationDTOAssemblerImplTest {

    @Test
    void toDTO() {
        // Arrange
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(new MutationId("123"));
        when(mutation.getDescription()).thenReturn(new Description("desc"));

        IMutationFactory factory = mock(IMutationFactory.class);
        MutationDTOAssemblerImpl mapper = new MutationDTOAssemblerImpl(factory);

        // Act
        MutationDTO dto = mapper.toDTO(mutation);

        // Assert
        assertEquals("123", dto.getMutationId());
        assertEquals("desc", dto.getDescription());
    }

    @Test
    void toDTO_withoutMocks() {
        // Arrange
        MutationId mutationId = new MutationId("123");
        Description description = new Description("desc");
        IMutationFactory factory = new MutationFactoryImpl();
        Mutation mutation = factory.createMutation(mutationId, description);

        MutationDTOAssemblerImpl mapper = new MutationDTOAssemblerImpl(factory);

        // Act
        MutationDTO dto = mapper.toDTO(mutation);

        // Assert
        assertEquals("123", dto.getMutationId());
        assertEquals("desc", dto.getDescription());
    }
}