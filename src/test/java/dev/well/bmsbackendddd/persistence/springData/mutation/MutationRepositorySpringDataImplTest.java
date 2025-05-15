package dev.well.bmsbackendddd.persistence.springData.mutation;

import dev.well.bmsbackendddd.domain.mutation.Mutation;
import dev.well.bmsbackendddd.domain.valueobject.MutationId;
import dev.well.bmsbackendddd.mapper.dataModelMapper.mutation.IMutationDataModelMapper;
import dev.well.bmsbackendddd.mapper.dataModelMapper.mutation.MutationDataModelMapperImpl;
import dev.well.bmsbackendddd.persistence.dataModel.MutationDataModel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MutationRepositorySpringDataImplTest {

    @Test
    void shouldCreateMutationRepositorySpringData() {
        //arrange
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        //act
        MutationRepositorySpringDataImpl result = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);
        //assert
        assertNotNull(result);
    }

    @Test
    void shouldThrowExceptionIfMutationRepositorySpringDataIsNull() {
        //arrange
        IMutationRepositorySpringData mutationRepositorySpringData = null;
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper));
    }

    @Test
    void shouldThrowExceptionIfMutationDataModelMapperIsNull() {
        //arrange
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper));
    }

    @Test
    void shouldSaveMutation(){
        //arrange
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);
        Mutation mutation = mock(Mutation.class);
        //act
        Mutation mutationSaved = repo.save(mutation);
        //assert
        assertEquals(mutationSaved,mutation);
    }

    @Test
    void shouldThrowExceptionIfMutationIsNull(){
        //arrange
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);
        Mutation mutation = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> repo.save(mutation));
    }

    @Test
    void shouldReturnAllMutations() {
        // arrange
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);

        List<MutationDataModel> dataModels = List.of(mock(MutationDataModel.class));
        List<Mutation> domainMutations = List.of(mock(Mutation.class));

        when(mutationRepositorySpringData.findAll()).thenReturn(dataModels);
        when(mutationDataModelMapper.toDomain(dataModels)).thenReturn(domainMutations);

        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);

        // act
        Iterable<Mutation> result = repo.findAll();

        // assert
        assertNotNull(result);
        assertEquals(domainMutations, result);
        verify(mutationRepositorySpringData).findAll();
        verify(mutationDataModelMapper).toDomain(dataModels);
    }

    @Test
    void shouldReturnMutationWhenOfIdentityExists() {
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);

        MutationId mutationId = mock(MutationId.class);
        MutationDataModel dataModel = mock(MutationDataModel.class);
        Mutation mutation = mock(Mutation.class);

        when(mutationId.toString()).thenReturn("id1");
        when(mutationRepositorySpringData.findById("id1")).thenReturn(Optional.of(dataModel));
        when(mutationDataModelMapper.toDomain(dataModel)).thenReturn(mutation);

        Optional<Mutation> result = repo.ofIdentity(mutationId);

        assertTrue(result.isPresent());
        assertEquals(mutation, result.get());
        verify(mutationRepositorySpringData).findById("id1");
        verify(mutationDataModelMapper).toDomain(dataModel);
    }

    @Test
    void shouldReturnEmptyWhenOfIdentityDoesNotExist() {
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);

        MutationId mutationId = mock(MutationId.class);

        when(mutationId.toString()).thenReturn("id2");
        when(mutationRepositorySpringData.findById("id2")).thenReturn(Optional.empty());

        Optional<Mutation> result = repo.ofIdentity(mutationId);

        assertTrue(result.isEmpty());
        verify(mutationRepositorySpringData).findById("id2");
        verifyNoInteractions(mutationDataModelMapper);
    }

    @Test
    void shouldReturnTrueWhenContainsOfIdentityExists() {
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);

        MutationId mutationId = mock(MutationId.class);

        when(mutationId.toString()).thenReturn("id3");
        when(mutationRepositorySpringData.existsById("id3")).thenReturn(true);

        boolean result = repo.containsOfIdentity(mutationId);

        assertTrue(result);
        verify(mutationRepositorySpringData).existsById("id3");
    }

    @Test
    void shouldReturnFalseWhenContainsOfIdentityDoesNotExist() {
        IMutationRepositorySpringData mutationRepositorySpringData = mock(IMutationRepositorySpringData.class);
        IMutationDataModelMapper mutationDataModelMapper = mock(MutationDataModelMapperImpl.class);
        MutationRepositorySpringDataImpl repo = new MutationRepositorySpringDataImpl(mutationRepositorySpringData, mutationDataModelMapper);

        MutationId mutationId = mock(MutationId.class);

        when(mutationId.toString()).thenReturn("id4");
        when(mutationRepositorySpringData.existsById("id4")).thenReturn(false);

        boolean result = repo.containsOfIdentity(mutationId);

        assertFalse(result);
        verify(mutationRepositorySpringData).existsById("id4");
    }

}