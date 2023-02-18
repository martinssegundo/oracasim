package br.com.tasdua.orcasim.api.dto.request.newInsurace;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewInsuranceDTO {
    private NewCarDTO car;
    private boolean active;
}
