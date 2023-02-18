package br.com.tasdua.orcasim.domain.usecases.impl.find;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;
import br.com.tasdua.orcasim.domain.usecases.IITemFinder;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.CarRepository;

public class CarFinder implements IITemFinder<Long, CarNotFoundException, Car> {

    CarRepository carRepository;
    RepositoryDomainMapper repositoryDomainMapper;

    public CarFinder(CarRepository carRepository,
                     RepositoryDomainMapper repositoryDomainMapper){
        this.carRepository = carRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public Car findByIdenrification(Long identifier) throws CarNotFoundException {
        return repositoryDomainMapper.convertToCar(
                carRepository.findById(identifier).orElseThrow(() -> new CarNotFoundException())
        );
    }
}
