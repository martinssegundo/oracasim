package br.com.tasdua.orcasim.api.dto.request.updateInsurance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDriverDTO {
    private Long id;
    private Long idCustumer;
    private String name;
    private String document;
    private LocalDate bithday;
    private boolean mainDriver;
    private boolean custumer;
    private List<LocalDate> claims;
}
