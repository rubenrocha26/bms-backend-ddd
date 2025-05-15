package dev.well.bmsbackendddd.mapper.dataModelMapper.mutation;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;

public interface IMutationDataModelMapper {
    Mutation toDomain(MutationDataModel mutationDataModel);
    Iterable<Mutation> toDomain (Iterable<MutationDataModel> mutationDataModels);
}
