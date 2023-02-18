package br.com.tasdua.orcasim.domain.usecases.impl.create;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.usecases.IItemCreator;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.CarRepository;
import br.com.tasdua.orcasim.repository.ClaimsRepository;

public class CarCreator implements IItemCreator<Car, CarNotFoundException> {
    private CarRepository carRepository;
    private ClaimsRepository claimsRepository;
    private RepositoryDomainMapper repositoryDomainMapper;

    public CarCreator(CarRepository carRepository,
                      ClaimsRepository claimsRepository,
                      RepositoryDomainMapper repositoryDomainMapper) {
        this.carRepository = carRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
        this.claimsRepository = claimsRepository;
    }

    @Override
    public Car create(Car car) throws CarNotFoundException {
        if (car == null)
            throw new CarNotFoundException();
        Car actualCar = null;
        try {
            actualCar = findCar(car);
        } catch (CarNotFoundException exception) {
            actualCar = repositoryDomainMapper.convertToCar(
                    this.carRepository.save(repositoryDomainMapper.convertToCarEntity(car))
            );
            createNewClaimsCar(actualCar);
        }

        return actualCar;
    }

    private void createNewClaimsCar(Car car) {
        car.getClaims().forEach(claimDate ->
                claimsRepository.save(
                        repositoryDomainMapper.convertToCarClaimsEntity(car, claimDate.getClaimDate())
                )
        );

    }

    private Car findCar(Car car) throws CarNotFoundException {

        var carFinded = repositoryDomainMapper.convertToCar(
                carRepository.findById(car.getId())
                        .orElseThrow(() -> new CarNotFoundException())
        );
        return carFinded;
    }

}
