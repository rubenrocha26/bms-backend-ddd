package dev.well.bmsbackendddd.persistence.dataModelMapper;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;

public interface IMutationDataModelMapper {
    Mutation toDomain(MutationDataModel mutationDataModel);
    Iterable<Mutation> toDomain (Iterable<MutationDataModel> mutationDataModels);
    MutationDataModel toDataModel (Mutation mutation);
}
