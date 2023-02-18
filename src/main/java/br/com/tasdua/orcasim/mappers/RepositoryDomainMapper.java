package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Custumer;
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

    Insurance convertToInsurance(InsuranceEntity insuranceEntity);

    @Mapping(source = "carDomain.id", target = "car.id")
    @Mapping(source = "custumerDomain.id", target = "custumer.id")
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "custumer", ignore = true)
    @Mapping(target = "id", ignore = true)
    InsuranceEntity convertToInsuranceEntity(Insurance insurance,
                                             Custumer custumerDomain,
                                             Car carDomain);

    @Mapping(source = "driver.id",target = "id")
    @Mapping(source = "claimDate",target = "claimDate")
    ClaimsEntity convertToDriverClaimsEntity(Driver driver, LocalDate claimDate);


    @Mapping(source = "car.id",target = "id")
    @Mapping(source = "claimDate",target = "claimDate")
    ClaimsEntity convertToCarClaimsEntity(Car car, LocalDate claimDate);


    @Mapping(source = "driver.id",target = "id")
    @Mapping(source = "driver.document",target = "document")
    @Mapping(source = "driver.bithdate",target = "bithday")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "mainDriver", ignore = true)
    @Mapping(target = "custumer", ignore = true)
    @Mapping(target = "claims", ignore = true)
    Driver convertToDriver(DriverEntity driver);

    @Mapping(source = "car.id",target = "id")
    @Mapping(source = "car.model",target = "model")
    @Mapping(source = "car.manufactured",target = "manufactured")
    @Mapping(source = "car.year",target = "year")
    @Mapping(source = "car.fipeValue",target = "fipeValue")
    @Mapping(target = "claims", ignore = true)
    @Mapping(target = "drivers", ignore = true)
    Car convertToCar(CarEntity car);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "carDomain.id",target = "car.id")
    @Mapping(source = "driverDomain.id",target = "driver.id")
    @Mapping(source = "driverDomain.mainDriver",target = "mainDriver")
    CarDriverEntity convertToCarDriverEntity(Car carDomain, Driver driverDomain);


    @Mapping(source = "driverDomain.id",target = "driver.id")
    CustumerEntity convertToCustumerEntity(Driver driverDomain);


    @Mapping(source = "driverDomain.bithday",target = "bithdate")
    DriverEntity convertToDriverEntity(Driver driverDomain);

    Custumer convertToCustumer(CustumerEntity custumer);
}
