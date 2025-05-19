package dev.well.bmsbackendddd.dto.dtoMapper;

import dev.well.bmsbackendddd.dto.MutationDto;
import dev.well.bmsbackendddd.domain.mutation.Mutation;

public interface IMutationDtoMapper {

    public Mutation toDomain (MutationDto mutationDTO);

    public MutationDto toDTO (Mutation mutation);
}
