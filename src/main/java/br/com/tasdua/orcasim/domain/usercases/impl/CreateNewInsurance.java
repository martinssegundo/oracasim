package br.com.tasdua.orcasim.domain.usercases.impl;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.CustumerNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;

public class CreateNewInsurance implements ICreateNewInsurance {

    private static final String CUSTUMER_NOT_FOUND = "CU01";

    private InsuranceRepository insuranceRepository;
    private DriverRepository driverRepository;
    private CustumerRepository custumerRepository;
    private ClaimsRepository claimsRepository;
    private CarRepository carRepository;
    private CarDriveRepository carDriveRepository;

    private RepositoryDomainMapper repositoryDomainMapper;

    public CreateNewInsurance(InsuranceRepository insuranceRepository,
                              DriverRepository driverRepository,
                              CustumerRepository custumerRepository,
                              ClaimsRepository claimsRepository,
                              CarRepository carRepository,
                              CarDriveRepository carDriveRepository,
                              RepositoryDomainMapper repositoryDomainMapper) {
        this.insuranceRepository = insuranceRepository;
        this.driverRepository = driverRepository;
        this.custumerRepository = custumerRepository;
        this.claimsRepository = claimsRepository;
        this.carRepository = carRepository;
        this.carDriveRepository = carDriveRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public void newInsurance(Insurance insurance) throws InsuranceException {
        try {
            createNewCar(insurance.getCar());
            createDrivers(insurance.getCar());
            createCustumer(insurance.getCar().findCustumer());
            createNewClaimsCar(insurance.getCar());
        }catch (CustumerNotFoundException custumerNotFoundException) {
            throw new InsuranceException(CUSTUMER_NOT_FOUND, "No custumer indentified");
        }
    }

    private void createNewCar(Car car) {
        var savedCar = repositoryDomainMapper.convertToCar(
                this.carRepository.save(repositoryDomainMapper.convertToCarEntity(car))
        );
        car.setId(savedCar.getId());
    }

    private void createDrivers(Car car) {
        car.getDrivers().forEach(driver -> {
                    var driverSaved = repositoryDomainMapper.convertToDriver(
                            driverRepository.save(
                                    repositoryDomainMapper.convertToDriverEntity(driver)
                            )
                    );
                    driver.setId(driverSaved.getId());
                    createNewClaimsDrivers(driverSaved);
                }
        );
    }

    private void createCustumer(Driver driver) {
        custumerRepository.save(
                repositoryDomainMapper.convertToCustumerEntity(driver)
        );
    }


    private void createNewClaimsCar(Car car) {
        car.getClaims().forEach(clameDate ->
                claimsRepository.save(
                        repositoryDomainMapper.convertToCarClaimsEntity(car, clameDate)
                )
        );
    }

    private void createNewClaimsDrivers(Driver driver) {
        driver.getClaims().forEach(clameDate ->
                claimsRepository.save(
                        repositoryDomainMapper.convertToDriverClaimsEntity(driver, clameDate)
                )
        );
    }

}
