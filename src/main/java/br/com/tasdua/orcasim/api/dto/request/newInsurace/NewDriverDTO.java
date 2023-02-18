package br.com.tasdua.orcasim.api.dto.request.newInsurace;

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
public class NewDriverDTO {
    private String name;
    private String document;
    private LocalDate bithday;
    private boolean mainDriver;
    private boolean custumer;
    private List<NewClaimsDTO> claims;
}
