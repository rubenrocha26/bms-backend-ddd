package dev.well.bmsbackendddd.DTO.DTOMapper;

import dev.well.bmsbackendddd.DTO.MutationDTO;
import dev.well.bmsbackendddd.domain.mutation.Mutation;

public interface IMutationDTOMapper {

    public Mutation toDomain (MutationDTO mutationDTO);

    public MutationDTO toDTO (Mutation mutation);
}
