package dev.well.bmsbackendddd.dto.mutation;

import dev.well.bmsbackendddd.dto.MutationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutationDtoTest {

    @Test
    void shouldCreateMutationDTOWithValidArguments() {
        MutationDto dto = new MutationDto("id123", "description");
        assertEquals("id123", dto.getMutationId());
        assertEquals("description", dto.getDescription());
    }

    @Test
    void shouldThrowExceptionWhenMutationIdIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDto(null, "description")
        );
        assertEquals("MutationId cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationIdIsBlank() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDto("   ", "description")
        );
        assertEquals("MutationId cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationDescriptionIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDto("id123", null)
        );
        assertEquals("MutationDescription cannot be null or blank", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMutationDescriptionIsBlank() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new MutationDto("id123", "   ")
        );
        assertEquals("MutationDescription cannot be null or blank", ex.getMessage());
    }

}