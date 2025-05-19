package dev.well.bmsbackendddd.dto.dtoMapper;

import dev.well.bmsbackendddd.dto.MutationDto;
import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.springframework.stereotype.Component;

@Component
public class MutationDtoMapperImpl implements IMutationDtoMapper {
    private final IMutationFactory _mutationFactory;

    public MutationDtoMapperImpl(IMutationFactory mutationFactory) {
        if(mutationFactory == null) {
            throw new NullPointerException("MutationFactory cannot be null");
        }
        this._mutationFactory = mutationFactory;
    }

    @Override
    public Mutation toDomain (MutationDto mutationDTO) {
        if(mutationDTO == null) {
            throw new IllegalArgumentException("MutationDTO cannot be null");
        }
        return _mutationFactory.createMutation(new MutationId(mutationDTO.getMutationId()), new Description(mutationDTO.getDescription()));
    }

    @Override
    public MutationDto toDTO (Mutation mutation) {
        if(mutation == null) {
            throw new IllegalArgumentException("Mutation cannot be null");
        }
        return new MutationDto(mutation.identity().toString(), mutation.getDescription().getDescription());
    }
}
