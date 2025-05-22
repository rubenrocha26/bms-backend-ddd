package dev.well.bmsbackendddd.dto.dtoAssembler;

import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.dto.BirdDTO;
import org.springframework.stereotype.Component;

@Component
public class BirdDTOAssemblerImpl implements IBirdDTOAssembler {

    @Override
    public BirdDTO toDTO (Bird bird, String mutationDescription) {
        if (bird == null) {
            throw new NullPointerException("Bird cannot be null");
        }
        return  new BirdDTO(
                bird.identity().toString(),
                bird.getBirdScientificName().toString(),
                bird.getBirdRing().toString(),
                bird.getMutationId().toString(),
                mutationDescription,
                bird.getBirdStatus().toString(),
                bird.getBirthDate().toString(),
                bird.getDeathDate().toString());
    }
}
