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

        createNewInsurance.newInsurance(
                InsuranceBuildUtil
                        .buildNewInsuranceWithoutCarClaimsAndMainDriver36AndCustumerAndDriverWithoutClaim()
        );
    }


    @Test
    void testNewInsuranceWithCustumer() throws InsuranceException {
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
                                .buildNewInsuranceWithoutCarClaimsAndDriver36WithoutCustumerAndDriverWithoutClaim()
                )
        );
    }
}

