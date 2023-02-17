package br.com.tasdua.orcasim.api.dto.request;

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
public class CarDTO {
    private String model;
    private String manufacturer;
    private String year;
    private BigDecimal fipeValue;
    private List<LocalDate> claims;
    private List<DriverDTO> drivers;
}
