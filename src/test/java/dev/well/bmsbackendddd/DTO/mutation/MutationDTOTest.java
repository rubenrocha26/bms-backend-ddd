package dev.well.bmsbackendddd.DTO.mutation;

import dev.well.bmsbackendddd.DTO.MutationDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutationDTOTest {

    @Test
    void shouldCreateMutationDTOWithValidArguments() {
        MutationDTO dto = new MutationDTO("id123", "description");
        assertEquals("id123", dto.getMutationId());
        assertEquals("description", dto.getMutationDescription());
    }

    @Test
    void shouldThrowExceptionWhenMutationIdIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDTO(null, "description")
        );
        assertEquals("MutationId cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationIdIsBlank() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDTO("   ", "description")
        );
        assertEquals("MutationId cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationDescriptionIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDTO("id123", null)
        );
        assertEquals("MutationDescription cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationDescriptionIsBlank() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDTO("id123", "   ")
        );
        assertEquals("MutationDescription cannot be null or blank", ex.getMessage());
    }

}