package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.domain.entities.*;
import br.com.tasdua.orcasim.repository.entities.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RepositoryDomainMapper {
    CarEntity convertToCarEntity(Car car);

    @Mapping(target = "calculatedValue", ignore = true)
    @Mapping(source = "insuranceEntity.car",target = "car")
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

    InsuranceEntity convertToInsuranceEntity(Insurance insurance);

    @Mapping(source = "driverDomain.id",target = "driver.id")
    @Mapping(source = "claimDate",target = "claimDate")
    @Mapping(target = "id", ignore = true)
    ClaimsEntity convertToDriverClaimsEntity(Driver driverDomain, LocalDate claimDate);


    @Mapping(source = "carDomain.id",target = "car.id")
    @Mapping(source = "claimDate",target = "claimDate")
    @Mapping(target = "id", ignore = true)
    ClaimsEntity convertToCarClaimsEntity(Car carDomain, LocalDate claimDate);


    @Mapping(source = "claim.car",target = "car.id")
    @Mapping(source = "claim.driver",target = "driver.id")
    @Mapping(source = "claim.id",target = "id")
    @Mapping(source = "claim.claimDate", target = "claimDate")
    ClaimsEntity convertToClaimsEntity(Claim claim);


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
    @Mapping(target = "id", ignore = true)
    CustumerEntity convertToCustumerEntity(Driver driverDomain);


    @Mapping(source = "driverDomain.bithday",target = "bithdate")
    DriverEntity convertToDriverEntity(Driver driverDomain);

    Custumer convertToCustumer(CustumerEntity custumer);
}
