package br.com.tasdua.orcasim.api.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsuranceDTO {
    private CarDTO car;
    private boolean active;
}
