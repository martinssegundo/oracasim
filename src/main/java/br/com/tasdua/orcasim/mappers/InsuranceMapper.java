package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InsuranceMapper {
    @Mapping(source = "insuranceDTO.car",target = "car")
    @Mapping(source = "insuranceDTO.active",target = "active" )
    Insurance convcertTo(InsuranceDTO insuranceDTO);
}
