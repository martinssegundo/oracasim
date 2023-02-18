package br.com.tasdua.orcasim.domain.usecases.impl.update;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.enums.ErrosCodeEnum;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.DriverNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.IUpdateInsurance;
import br.com.tasdua.orcasim.domain.usecases.impl.create.CarCreator;
import br.com.tasdua.orcasim.domain.usecases.impl.create.DriverCreator;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.*;

public class UpdateInsurance implements IUpdateInsurance {

    private InsuranceRepository insuranceRepository;
    private DriverCreator driverCreator;
    private CustumerRepository custumerRepository;
    private ClaimsRepository claimsRepository;
    private CarCreator carCreator;
    private CarDriveRepository carDriveRepository;

    private RepositoryDomainMapper repositoryDomainMapper;

    public UpdateInsurance(InsuranceRepository insuranceRepository,
                           DriverCreator driverCreator,
                           CustumerRepository custumerRepository,
                           ClaimsRepository claimsRepository,
                           CarCreator carCreator,
                           CarDriveRepository carDriveRepository,
                           RepositoryDomainMapper repositoryDomainMapper) {
        this.insuranceRepository = insuranceRepository;
        this.driverCreator = driverCreator;
        this.custumerRepository = custumerRepository;
        this.claimsRepository = claimsRepository;
        this.carCreator = carCreator;
        this.carDriveRepository = carDriveRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public Insurance updateInsurance(Insurance insurance) throws InsuranceException {
        try {
            var car = carCreator.create(insurance.getCar());
        } catch (CarNotFoundException e) {
            throw new InsuranceException(ErrosCodeEnum.CAR_NOT_FOUND);
        }
        return null;
    }


    private void updateDrivers(Car car) throws DriverNotFoundException {
        if (car.getDrivers().isEmpty())
            throw new DriverNotFoundException();
        driverCreator.create(car.getDrivers());
    }

    private void updateClaimsCar(Car car) {
        car.getClaims().forEach(claim -> claimsRepository.save(
                repositoryDomainMapper.convertToClaimsEntity(claim)
        ));
    }

    private void updateClaimsDriver(Driver driver) {
        driver.getClaims().forEach(claim -> claimsRepository.save(
                repositoryDomainMapper.convertToClaimsEntity(claim)
        ));
    }


    private void updateCustumer(Driver driver){

    }
}
