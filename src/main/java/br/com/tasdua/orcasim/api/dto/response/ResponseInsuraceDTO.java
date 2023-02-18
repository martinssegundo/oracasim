package br.com.tasdua.orcasim.api.dto.response;

import br.com.tasdua.orcasim.api.dto.response.data.InsuranceSummary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseInsuraceDTO {
    public InsuranceSummary data;
}
