package dev.well.bmsbackendddd.DTO.DTOMapper;

import dev.well.bmsbackendddd.DTO.MutationDTO;
import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import org.springframework.stereotype.Component;

@Component
public class MutationDTOMapperImpl implements IMutationDTOMapper {
    private final IMutationFactory _mutationFactory;

    public MutationDTOMapperImpl(IMutationFactory mutationFactory) {
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
        return _mutationFactory.createMutation(new Description(mutationDTO.getDescription()));
    }

//    @Override
//    public Mutation toDomain (MutationDTO mutationDTO) {
//        if(mutationDTO == null) {
//            throw new IllegalArgumentException("MutationDTO cannot be null");
//        }
//        return _mutationFactory.createMutation(new MutationId(mutationDTO.getMutationId()),new Description(mutationDTO.getDescription()));
//    }

    @Override
    public MutationDTO toDTO (Mutation mutation) {
        if(mutation == null) {
            throw new IllegalArgumentException("Mutation cannot be null");
        }
        return new MutationDTO(mutation.identity().toString(), mutation.getDescription().toString());
    }
}
