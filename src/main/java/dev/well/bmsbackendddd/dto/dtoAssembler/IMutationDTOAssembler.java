package dev.well.bmsbackendddd.dto.dtoAssembler;

import dev.well.bmsbackendddd.dto.MutationDTO;
import dev.well.bmsbackendddd.domain.mutation.Mutation;

public interface IMutationDTOAssembler {

    public Mutation toDomain (MutationDTO mutationDTO);

    public MutationDTO toDTO (Mutation mutation);
}
