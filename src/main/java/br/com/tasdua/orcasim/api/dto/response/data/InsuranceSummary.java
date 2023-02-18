package br.com.tasdua.orcasim.api.dto.response.data;

import br.com.tasdua.orcasim.api.dto.request.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsuranceSummary {
    private Long protocol;
    private BigDecimal carValue;
    private BigDecimal insuranceValue;
    private List<DriverDTO> drivers;
    private boolean active;
}
