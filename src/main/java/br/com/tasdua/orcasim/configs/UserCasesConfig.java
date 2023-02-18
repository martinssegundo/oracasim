package br.com.tasdua.orcasim.configs;

import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;
import br.com.tasdua.orcasim.domain.usercases.impl.CreateNewInsurance;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCasesConfig {

    @Bean
    public ICreateNewInsurance createCreateNewInsuranceUserCase(InsuranceRepository insuranceRepository,
                                                                DriverRepository driverRepository,
                                                                CustumerRepository custumerRepository,
                                                                ClaimsRepository claimsRepository,
                                                                CarRepository carRepository,
                                                                CarDriveRepository carDriveRepository,
                                                                RepositoryDomainMapper repositoryDomainMApper){
        return new CreateNewInsurance(insuranceRepository,driverRepository,
                custumerRepository,claimsRepository,
                carRepository,carDriveRepository,repositoryDomainMApper);
    }

}
