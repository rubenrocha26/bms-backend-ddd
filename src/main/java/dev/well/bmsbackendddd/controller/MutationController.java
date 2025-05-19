package dev.well.bmsbackendddd.controller;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.Description;
import dev.well.bmsbackendddd.dto.dtoMapper.IMutationDtoMapper;
import dev.well.bmsbackendddd.dto.MutationDto;
import dev.well.bmsbackendddd.service.mutation.IMutationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mutations")
public class MutationController {

    private final IMutationService _mutationService;
    private final IMutationDtoMapper _mutationDTOMapper;

    public MutationController(IMutationService mutationService, IMutationDtoMapper mutationDTOMapper) {
        if (mutationService == null || mutationDTOMapper == null) {
            throw new IllegalArgumentException("MutationService and mutationDTOMapper cannot be null");
        }
        this._mutationService = mutationService;
        this._mutationDTOMapper = mutationDTOMapper;
    }

    //Add Bird REST API
    @PostMapping
    public ResponseEntity<?> createMutation (@RequestBody String description){
        try {
            Description descriptionForMutation = new Description(description);
            Optional<Mutation> savedMutation = _mutationService.createAndSaveMutation(descriptionForMutation);

            if (savedMutation.isPresent()) {
                MutationDto mutationDtoSaved = _mutationDTOMapper.toDTO(savedMutation.get());
                return new ResponseEntity<>(mutationDtoSaved, HttpStatus.CREATED);

            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Mutation already exists or invalid input.");

            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid description: " + e.getMessage());
        }
    }
}
