package dev.well.bmsbackendddd.dto.dtoAssembler;

import dev.well.bmsbackendddd.dto.MutationDTO;
import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.springframework.stereotype.Component;

@Component
public class MutationDTOAssemblerImpl implements IMutationDTOAssembler {
    private final IMutationFactory _mutationFactory;

    public MutationDTOAssemblerImpl(IMutationFactory mutationFactory) {
        if(mutationFactory == null) {
            throw new NullPointerException("MutationFactory cannot be null");
        }
        this._mutationFactory = mutationFactory;
    }

    @Override
    public Mutation toDomain (MutationDTO mutationDTO) {
        if(mutationDTO == null) {
            throw new IllegalArgumentException("MutationDTO cannot be null");
        }
        return _mutationFactory.createMutation(new MutationId(mutationDTO.getMutationId()), new Description(mutationDTO.getDescription()));
    }

    @Override
    public MutationDTO toDTO (Mutation mutation) {
        if(mutation == null) {
            throw new IllegalArgumentException("Mutation cannot be null");
        }
        return new MutationDTO(mutation.identity().toString(), mutation.getDescription().getDescription());
    }
}
