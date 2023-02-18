package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.DriverNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.impl.create.CarCreator;
import br.com.tasdua.orcasim.domain.usecases.impl.create.CreateNewInsurance;
import br.com.tasdua.orcasim.domain.usecases.impl.create.DriverCreator;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;
import br.com.tasdua.orcasim.repository.entities.*;
import br.com.tasdua.orcasim.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CreateNewInsuranceTest {
    private static final int DEFAULT_PERCENT_INSURANCE_STARTER = 6;
    private static final int AGE_RISK_START = 18;
    private static final int AGE_RISK_FINAL = 25;
    @Mock
    InsuranceRepository insuranceRepository;
    @Mock
    DriverCreator driverCreator;
    @Mock
    CarCreator carCreator;
    @Mock
    CustumerRepository custumerRepository;
    @Mock
    ClaimsRepository claimsRepository;
    @Mock
    CarDriveRepository carDriveRepository;
    @Spy
    RepositoryDomainMapper repositoryDomainMapper = Mappers.getMapper(RepositoryDomainMapper.class);
    @Spy
    InsuranceMapper insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    @InjectMocks
    CreateNewInsurance createNewInsurance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNewInsuranceWithSucess() throws InsuranceException, DriverNotFoundException, CarNotFoundException {
        when(carCreator.create(any(Car.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithoutClaims()
                );
        when(driverCreator.create(any(List.class)))
                .thenReturn(
                        List.of(DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID())
                );
        when(custumerRepository.save(any(CustumerEntity.class)))
                .thenReturn(
                        CustumerBuilderUtil.buildCustumerEntity()
                );
        when(claimsRepository.save(any(ClaimsEntity.class)))
                .thenReturn(
                        ClaimBuilderUtil.buiuldClaimEntity()
                );
        when(insuranceRepository.save(any(InsuranceEntity.class)))
                .thenReturn(
                        InsuranceBuildUtil
                                .buildNewInsuranceEntityWithoutCarClaimsAndDriver36AndDriverWithoutClaimWithID()
                );
        when(carDriveRepository.save(any(CarDriverEntity.class)))
                .thenReturn(
                        CarDriverEntity.builder()
                                .id(1L)
                                .driver(DriverEntity.builder().id(1L).build())
                                .car(CarEntity.builder().id(1L).build())
                                .mainDriver(true)
                                .build()
                );

        var insurance = createNewInsurance.create(
                InsuranceBuildUtil
                        .buildNewInsuranceWithoutCarClaimsAndMainDriver36AndCustumerAndDriverWithoutClaim(),
                DEFAULT_PERCENT_INSURANCE_STARTER,
                AGE_RISK_START,
                AGE_RISK_FINAL
        );

        assertNotNull(insurance);
    }

    @Test
    void testNewInsuranceWithCarExcption() throws CarNotFoundException {
        when(carCreator.create(null))
                .thenThrow(new CarNotFoundException());
        assertThrows(InsuranceException.class,
                () -> createNewInsurance.create(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithoutCar(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }


    @Test
    void testNewInsuranceWithDriverExcption() throws CarNotFoundException {
        when(carCreator.create(any(Car.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarWithClaimsWithoutDriver()
                );
        assertThrows(InsuranceException.class,
                () -> createNewInsurance.create(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithCarWithoutDriver(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }


    @Test
    void testNewInsuranceWithCustumerExcption() throws DriverNotFoundException, CarNotFoundException {
        when(carCreator.create(any(Car.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarWithClaimsAndMainDriver18WithClaims()
                );
        when(driverCreator.create(any(List.class)))
                .thenReturn(
                        List.of(DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID())
                );
        when(custumerRepository.save(any(CustumerEntity.class)))
                .thenReturn(
                        CustumerBuilderUtil.buildCustumerEntity()
                );
        when(claimsRepository.save(any(ClaimsEntity.class)))
                .thenReturn(
                        ClaimBuilderUtil.buiuldClaimEntity()
                );
        when(insuranceRepository.save(any(InsuranceEntity.class)))
                .thenReturn(
                        InsuranceBuildUtil
                                .buildNewInsuranceEntityWithoutCarClaimsAndDriver36AndDriverWithoutClaimWithID()
                );

        assertThrows(InsuranceException.class,
                () -> createNewInsurance.create(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithoutCarClaimsAndDriver36WithoutCustumerAndDriverWithoutClaim(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }
}

