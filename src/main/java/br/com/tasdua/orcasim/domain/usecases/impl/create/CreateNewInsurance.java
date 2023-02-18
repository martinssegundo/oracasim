package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Custumer;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.enums.ErrosCodeEnum;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.CustumerNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.DriverNotFoundException;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.ICreateNewInsurance;
import br.com.tasdua.orcasim.domain.usecases.IItemCreator;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.CarDriveRepository;
import br.com.tasdua.orcasim.repository.ClaimsRepository;
import br.com.tasdua.orcasim.repository.CustumerRepository;
import br.com.tasdua.orcasim.repository.InsuranceRepository;

import java.util.List;

public class CreateNewInsurance implements ICreateNewInsurance {

    private InsuranceRepository insuranceRepository;
    private IItemCreator<List<Driver>, DriverNotFoundException> driverCreator;
    private IItemCreator<Car, CarNotFoundException> carCreator;
    private CustumerRepository custumerRepository;
    private CarDriveRepository carDriveRepository;

    private RepositoryDomainMapper repositoryDomainMapper;

    public CreateNewInsurance(InsuranceRepository insuranceRepository,
                              DriverCreator driverCreator,
                              CustumerRepository custumerRepository,
                              CarCreator carCreator,
                              CarDriveRepository carDriveRepository,
                              RepositoryDomainMapper repositoryDomainMapper) {
        this.insuranceRepository = insuranceRepository;
        this.driverCreator = driverCreator;
        this.custumerRepository = custumerRepository;
        this.carCreator = carCreator;
        this.carDriveRepository = carDriveRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public Insurance create(Insurance insurance, int defaulPercentInsuramce,
                            int ageRiskStart, int ageRiskFinal) throws InsuranceException {
        try {
            var car = carCreator.create(insurance.getCar());
            createDrivers(insurance.getCar());
            createCarDriver(car);
            var custumer = createCustumer(insurance.getCar().findCustumer());

            return save(insurance,custumer,
                    defaulPercentInsuramce,
                    ageRiskStart,ageRiskFinal);

        } catch (CustumerNotFoundException custumerNotFoundException) {
            throw new InsuranceException(ErrosCodeEnum.CUSTUMER_NOT_FOUND);
        } catch (CarNotFoundException carNotFoundException) {
            throw new InsuranceException(ErrosCodeEnum.CAR_NOT_FOUND);
        } catch (DriverNotFoundException driverNotFoundException) {
            throw new InsuranceException(ErrosCodeEnum.DRIVE_NOT_FOUND);
        }
    }

    private Insurance save(Insurance insurance, Custumer custumer,
                           int defaulPercentInsuramce,
                           int ageRiskStart, int ageRiskFinal){
        var insuranceSaved = insuranceRepository.save(
                repositoryDomainMapper
                        .convertToInsuranceEntity(insurance, custumer, insurance.getCar()
                        )
        );
        insurance.setId(insuranceSaved.getId());
        insurance.setCalculatedValue(
                insurance.calculateValue(defaulPercentInsuramce, ageRiskStart, ageRiskFinal));
        return insurance;
    }

    private void createDrivers(Car car) throws DriverNotFoundException {
        if (car.getDrivers().isEmpty())
            throw new DriverNotFoundException();
        driverCreator.create(car.getDrivers());
    }

    private Custumer createCustumer(Driver driver) {

        return repositoryDomainMapper.convertToCustumer(
                custumerRepository.save(
                        repositoryDomainMapper.convertToCustumerEntity(driver)
                ));
    }

    private void createCarDriver(Car car) {
        car.getDrivers().forEach(
                driver -> carDriveRepository.save(
                        repositoryDomainMapper.convertToCarDriverEntity(car, driver)
                )
        );
    }


}
