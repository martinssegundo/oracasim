package br.com.tasdua.orcasim.domain.usecases.impl;

import br.com.tasdua.orcasim.domain.usecases.impl.update.UpdateInsurance;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;
import br.com.tasdua.orcasim.utils.InsuranceBuildUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UpdateInsuranceTest {
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
    @Mock
    RepositoryDomainMapper repositoryDomainMapper;
    @InjectMocks
    UpdateInsurance updateInsurance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateInsurance() {
        var insurance = InsuranceBuildUtil
                .buildExistentInsuranceWithoutCarClaimsAndMainDriver36AndCustumerAndDriverWithoutClaim();
        //Insurance result = updateInsurance.updateInsurance(insurance);
        //Assertions.assertEquals(result, result);
    }
}