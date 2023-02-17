package br.com.tasdua.orcasim.api.dto.response;

import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseInsuraceDTO {
    public InsuranceDTO data;
}
