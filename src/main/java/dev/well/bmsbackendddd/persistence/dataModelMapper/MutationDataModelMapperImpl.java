package dev.well.bmsbackendddd.persistence.dataModelMapper;

import dev.well.bmsbackendddd.domain.mutation.IMutationFactory;
import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MutationDataModelMapperImpl implements IMutationDataModelMapper {

    private final IMutationFactory _mutationFactory;

    public MutationDataModelMapperImpl (IMutationFactory mutationFactory) {
        if (mutationFactory == null) {
            throw new IllegalArgumentException("MutationFactory cannot be null");
        }
        this._mutationFactory = mutationFactory;
    }

    @Override
    public Mutation toDomain (MutationDataModel mutationDataModel){
        MutationId mutationId = new MutationId(mutationDataModel.getMutationId());
        Description description = new Description(mutationDataModel.getDescription());

        return _mutationFactory.createMutation(mutationId, description);
    }

    @Override
    public Iterable<Mutation> toDomain (Iterable<MutationDataModel> listMutationDataModel){
        List<Mutation> listMutationDomain = new ArrayList<>();

        listMutationDataModel.forEach(mutationDataModel ->{
            MutationId mutationId = new MutationId(mutationDataModel.getMutationId());
            Description description = new Description(mutationDataModel.getDescription());
            Mutation mutationDomain = _mutationFactory.createMutation(mutationId,description);

            listMutationDomain.add(mutationDomain);

        });

        return listMutationDomain;
    }

    @Override
    public MutationDataModel toDataModel (Mutation mutation){
        String mutationId = mutation.identity().toString();
        String description = mutation.getDescription().toString();

        return new  MutationDataModel(mutationId,description);
    }
}
