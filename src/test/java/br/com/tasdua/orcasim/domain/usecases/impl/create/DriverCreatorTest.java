package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.excptions.DriverNotFoundException;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.ClaimsRepository;
import br.com.tasdua.orcasim.repository.DriverRepository;
import br.com.tasdua.orcasim.utils.DriverBuilderUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DriverCreatorTest {
    @Mock
    DriverRepository driverRepository;
    @Mock
    ClaimsRepository claimsRepository;
    @Spy
    RepositoryDomainMapper repositoryDomainMapper = Mappers.getMapper(RepositoryDomainMapper.class);
    @Spy
    InsuranceMapper insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    @InjectMocks
    DriverCreator driverCreator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() throws DriverNotFoundException {
        when(driverRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        when(driverRepository.save(any()))
                .thenReturn(DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID());

        assertNotNull(driverCreator.create(
                        List.of(DriverBuilderUtils.buildMainDriver36WithoutClainsWithID())
                )
        );
    }
}
