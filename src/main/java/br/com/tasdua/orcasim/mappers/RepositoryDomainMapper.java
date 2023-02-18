package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.repository.entities.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RepositoryDomainMapper {
    CarEntity convertToCarEntity(Car car);
    InsuranceEntity convertToInsuranceEntity(Insurance insurance);

    @Mapping(source = "driver.id",target = "id")
    @Mapping(source = "claimDate",target = "claimDate")
    ClaimsEntity convertToDriverClaimsEntity(Driver driver, LocalDate claimDate);


    @Mapping(source = "car.id",target = "id")
    @Mapping(source = "claimDate",target = "claimDate")
    ClaimsEntity convertToCarClaimsEntity(Car car, LocalDate claimDate);


    @Mapping(source = "driver.id",target = "id")
    @Mapping(source = "driver.document",target = "document")
    @Mapping(source = "driver.bithdate",target = "bithday")
    Driver convertToDriver(DriverEntity driver);

    @Mapping(source = "car.id",target = "id")
    @Mapping(source = "car.model",target = "model")
    @Mapping(source = "car.manufactured",target = "manufactured")
    @Mapping(source = "car.year",target = "year")
    @Mapping(source = "car.fipeValue",target = "fipeValue")
    Car convertToCar(CarEntity car);


    @Mapping(source = "car.id",target = "id")
    CarDriverEntity convertToCarDriverEntity(Car car, Driver driver);


    @Mapping(source = "driverDomain.id",target = "driver.id")
    CustumerEntity convertToCustumerEntity(Driver driverDomain);


    @Mapping(source = "driverDomain.bithday",target = "bithdate")
    DriverEntity convertToDriverEntity(Driver driverDomain);
}
