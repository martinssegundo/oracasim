package br.com.tasdua.orcasim.mappers;

import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    Insurance convcertTo(InsuranceDTO insuranceDTO);
}
