package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.DriverNotFoundException;
import br.com.tasdua.orcasim.domain.usecases.IItemCreator;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.ClaimsRepository;
import br.com.tasdua.orcasim.repository.DriverRepository;

import java.util.List;

public class DriverCreator implements IItemCreator<List<Driver>, DriverNotFoundException> {


    private DriverRepository driverRepository;
    private ClaimsRepository claimsRepository;

    RepositoryDomainMapper repositoryDomainMapper;



    public DriverCreator(DriverRepository driverRepository,
                         ClaimsRepository claimsRepository,
                         RepositoryDomainMapper repositoryDomainMapper){
        this.driverRepository =driverRepository;
        this.claimsRepository = claimsRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public List<Driver> create(List<Driver> drivers) throws DriverNotFoundException {
        if(drivers == null)
            throw new DriverNotFoundException();
        drivers.forEach(driver -> {
            Driver actualDriver = null;
            try{
                actualDriver = findDriver(driver);
            }catch (DriverNotFoundException ex){
                actualDriver = repositoryDomainMapper.convertToDriver(
                        driverRepository.save(
                                repositoryDomainMapper.convertToDriverEntity(driver)
                        )
                );
                createNewClaimsDrivers(driver);
            }
            driver.setId(actualDriver.getId());
        });
        return drivers;
    }

    private void createNewClaimsDrivers(Driver driver) {
        driver.getClaims().forEach(claimDate ->
                claimsRepository.save(
                        repositoryDomainMapper.convertToDriverClaimsEntity(driver, claimDate.getClaimDate())
                )
        );
    }


    private Driver findDriver(Driver driver) throws DriverNotFoundException {
        return repositoryDomainMapper.convertToDriver(
                driverRepository.findById(driver.getId())
                        .orElseThrow(() -> new DriverNotFoundException())
        );
    }
}
