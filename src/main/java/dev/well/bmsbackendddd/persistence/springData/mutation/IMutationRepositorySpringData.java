package dev.well.bmsbackendddd.persistence.springData.mutation;

import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMutationRepositorySpringData extends JpaRepository<MutationDataModel, String> {
}
