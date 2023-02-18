package br.com.tasdua.orcasim.api.dto.request.updateInsurance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateCarDTO {
    private String model;
    private String manufacturer;
    private String year;
    private BigDecimal fipeValue;
    private List<UpdateClaimsDTO> claims;
    private List<UpdateDriverDTO> drivers;
}
