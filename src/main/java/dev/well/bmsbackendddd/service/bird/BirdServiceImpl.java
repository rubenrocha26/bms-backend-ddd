package dev.well.bmsbackendddd.service.bird;

import dev.well.bmsbackendddd.domain.bird.Bird;
import dev.well.bmsbackendddd.domain.bird.IBirdFactory;
import dev.well.bmsbackendddd.domain.valueobject.BirdRing;
import dev.well.bmsbackendddd.domain.valueobject.BirdScientificName;
import dev.well.bmsbackendddd.domain.valueobject.Date;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.dto.BirdDTO;
import dev.well.bmsbackendddd.dto.dtoAssembler.IBirdDTOAssembler;
import dev.well.bmsbackendddd.repository.IBirdRepository;
import dev.well.bmsbackendddd.repository.IMutationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BirdServiceImpl implements IBirdService {
    private final IBirdFactory _birdFactory;
    private final IBirdRepository _birdRepository;
    private final IMutationRepository _mutationRepository;
    private final IBirdDTOAssembler _birdDTOAssembler;

    public BirdServiceImpl(IBirdFactory birdFactory, IBirdRepository birdRepository, IMutationRepository mutationRepository, IBirdDTOAssembler birdDTOAssembler) {
        if (birdFactory == null){
            throw new IllegalArgumentException("BirdFactory cannot be null");
        }
        if (birdRepository == null){
            throw new IllegalArgumentException("BirdRepository cannot be null");
        }
        if (mutationRepository == null){
            throw new IllegalArgumentException("MutationRepository cannot be null");
        }
        if (birdDTOAssembler == null){
            throw new IllegalArgumentException("BirdDTOAssembler cannot be null");
        }
        this._birdFactory = birdFactory;
        this._birdRepository = birdRepository;
        this._mutationRepository = mutationRepository;
        this._birdDTOAssembler = birdDTOAssembler;
    }

    @Override
    public Optional<BirdDTO> createAndSaveBird (BirdDTO birdDTO) {
        if (birdDTO == null){
            throw new IllegalArgumentException("BirdDTO cannot be null");
        }
        try{
            BirdScientificName birdScientificName = new BirdScientificName(birdDTO.getBirdScientificName());
            BirdRing birdRing = new BirdRing(birdDTO.getBirdRing());
            MutationId mutationId = new MutationId(birdDTO.getMutationId());
            Date dateOfBirth = new Date(LocalDate.parse(birdDTO.getBirthDate()));

            boolean isBirdAlreadyRegistered = _birdRepository.existsByBirdRing(birdRing);
            if (!isBirdAlreadyRegistered){
                Bird newBird = _birdFactory.createBird(birdScientificName, birdRing, mutationId, dateOfBirth);
                _birdRepository.save(newBird);
                if (newBird.hasMutation()){
                    String description = _mutationRepository.getDescriptionByMutationId(newBird.getMutationId());
                    return Optional.of(_birdDTOAssembler.toDTO(newBird, description));
                }
                return Optional.of(_birdDTOAssembler.toDTO(newBird,null));
            }
        }catch (Exception e){
            return  Optional.empty();
        }
        return Optional.empty();
    }
}
