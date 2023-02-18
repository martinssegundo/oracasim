package br.com.tasdua.orcasim.api.dto.request.updateInsurance;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateInsuranceDTO {
    private UpdateCarDTO car;
    private boolean active;
}
