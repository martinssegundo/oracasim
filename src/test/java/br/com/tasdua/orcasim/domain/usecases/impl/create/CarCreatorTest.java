package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.CarRepository;
import br.com.tasdua.orcasim.repository.ClaimsRepository;
import br.com.tasdua.orcasim.repository.entities.CarEntity;
import br.com.tasdua.orcasim.utils.CarBuilderUtil;
import br.com.tasdua.orcasim.utils.ClaimBuilderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CarCreatorTest {
    @Mock
    CarRepository carRepository;
    @Mock
    ClaimsRepository claimsRepository;
    @Spy
    RepositoryDomainMapper repositoryDomainMapper = Mappers.getMapper(RepositoryDomainMapper.class);
    @Spy
    InsuranceMapper insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    @InjectMocks
    CarCreator carCreator;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() throws CarNotFoundException {
        when(carRepository.findById(1L))
                .thenReturn(Optional.empty());
        when(carRepository.save(any(CarEntity.class)))
                .thenReturn(CarBuilderUtil.buildCarEntityWithID());

        assertNotNull(carCreator.create(
                        CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithCustumerWithoutClaimsWithID()
                )
        );
    }
}
