package br.com.tasdua.orcasim.configs;

import br.com.tasdua.orcasim.domain.usecases.ICreateNewInsurance;
import br.com.tasdua.orcasim.domain.usecases.IItemCreator;
import br.com.tasdua.orcasim.domain.usecases.impl.create.CarCreator;
import br.com.tasdua.orcasim.domain.usecases.impl.create.CreateNewInsurance;
import br.com.tasdua.orcasim.domain.usecases.impl.create.DriverCreator;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class UseCasesCreatorsConfig {

    @Bean
    public ICreateNewInsurance createCreateNewInsuranceUserCase(InsuranceRepository insuranceRepository,
                                                                DriverCreator driverCreator,
                                                                CustumerRepository custumerRepository,
                                                                CarCreator carCreator,
                                                                CarDriveRepository carDriveRepository,
                                                                RepositoryDomainMapper repositoryDomainMApper){
        return new CreateNewInsurance(insuranceRepository,driverCreator,
                custumerRepository, carCreator,
                carDriveRepository,repositoryDomainMApper);
    }


    @Order(1)
    @Bean
    public IItemCreator createCarCreator(ClaimsRepository claimsRepository,
                                         CarRepository carRepository,
                                         RepositoryDomainMapper repositoryDomainMApper){
        return new CarCreator(carRepository,claimsRepository,repositoryDomainMApper);
    }

    @Order(1)
    @Bean
    public IItemCreator createDriverCreator(ClaimsRepository claimsRepository,
                                            DriverRepository driverRepository,
                                            RepositoryDomainMapper repositoryDomainMapper){
        return new DriverCreator(driverRepository,claimsRepository,repositoryDomainMapper);
    }

}
