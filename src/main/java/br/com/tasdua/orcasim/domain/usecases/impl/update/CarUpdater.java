package br.com.tasdua.orcasim.domain.usecases.impl.update;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.usecases.IItemUpdate;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.CarRepository;
import br.com.tasdua.orcasim.repository.ClaimsRepository;

public class CarUpdater implements IItemUpdate<Car, CarNotFoundException> {

    private CarRepository carRepository;
    private ClaimsRepository claimsRepository;
    private RepositoryDomainMapper repositoryDomainMapper;


    public CarUpdater(CarRepository carRepository,
                      ClaimsRepository claimsRepository,
                      RepositoryDomainMapper repositoryDomainMapper) {
        this.carRepository = carRepository;
        this.claimsRepository = claimsRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public Car update(Car car) throws CarNotFoundException {
        return repositoryDomainMapper.convertToCar(
                carRepository.save(repositoryDomainMapper.convertToCarEntity(car))
        );
    }

}
