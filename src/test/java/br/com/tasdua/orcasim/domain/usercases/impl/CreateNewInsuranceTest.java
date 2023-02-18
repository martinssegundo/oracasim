package br.com.tasdua.orcasim.domain.usercases.impl;

import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
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
    DriverRepository driverRepository;
    @Mock
    CustumerRepository custumerRepository;
    @Mock
    ClaimsRepository claimsRepository;
    @Mock
    CarRepository carRepository;
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
    void testNewInsuranceWithSucess() throws InsuranceException {
        when(carRepository.save(any(CarEntity.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarEntityWithID()
                );
        when(driverRepository.save(any(DriverEntity.class)))
                .thenReturn(
                        DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID()
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

        var insurance = createNewInsurance.newInsurance(
                InsuranceBuildUtil
                        .buildNewInsuranceWithoutCarClaimsAndMainDriver36AndCustumerAndDriverWithoutClaim(),
                DEFAULT_PERCENT_INSURANCE_STARTER,
                AGE_RISK_START,
                AGE_RISK_FINAL
        );

        assertNotNull(insurance);
    }


    @Test
    void testNewInsuranceWithCustumerExcption() {
        when(carRepository.save(any(CarEntity.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarEntityWithID()
                );
        when(driverRepository.save(any(DriverEntity.class)))
                .thenReturn(
                        DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID()
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
                () -> createNewInsurance.newInsurance(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithoutCarClaimsAndDriver36WithoutCustumerAndDriverWithoutClaim(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }

    @Test
    void testNewInsuranceWithCarExcption() {
        assertThrows(InsuranceException.class,
                () -> createNewInsurance.newInsurance(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithoutCar(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }


    @Test
    void testNewInsuranceWithDriverExcption() {
        when(carRepository.save(any(CarEntity.class)))
                .thenReturn(
                        CarBuilderUtil.buildCarEntityWithID()
                );


        assertThrows(InsuranceException.class,
                () -> createNewInsurance.newInsurance(
                        InsuranceBuildUtil
                                .buildNewInsuranceWithCarWithoutDriver(),
                        DEFAULT_PERCENT_INSURANCE_STARTER,
                        AGE_RISK_START,
                        AGE_RISK_FINAL
                )
        );
    }
}

