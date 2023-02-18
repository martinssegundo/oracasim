package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.api.dto.request.newInsurace.NewClaimsDTO;
import br.com.tasdua.orcasim.api.dto.request.newInsurace.NewInsuranceDTO;
import br.com.tasdua.orcasim.api.dto.request.updateInsurance.UpdateInsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.data.InsuranceSummary;
import br.com.tasdua.orcasim.domain.entities.Claim;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InsuranceMapper {

    @Mapping(target = "car.claims", ignore = true)
    @Mapping(target = "car.drivers.claims", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calculatedValue", ignore = true)
    @Mapping(source = "newInsuranceDTO.car",target = "car")
    @Mapping(source = "newInsuranceDTO.active",target = "active" )
    Insurance convcertToInsurance(NewInsuranceDTO newInsuranceDTO);

    //Insurance convcertToInsurance(UpdateInsuranceDTO newInsuranceDTO);

    @Mapping(source = "insurance.car.fipeValue",target = "carValue")
    @Mapping(source = "insurance.calculatedValue",target = "insuranceValue" )
    @Mapping(source = "insurance.car.drivers",target = "drivers" )
    @Mapping(source = "insurance.id", target = "protocol")
    InsuranceSummary convcertToInsuranceSummary(Insurance insurance);


    NewClaimsDTO converTo(Claim claim);
}

