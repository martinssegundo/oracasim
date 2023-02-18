package br.com.tasdua.orcasim.api.dto.request.updateInsurance;

import java.time.LocalDate;

public class UpdateClaimsDTO {
    private Long id;
    private Long carId;
    private Long driverId;
    private LocalDate claimDate;
}
