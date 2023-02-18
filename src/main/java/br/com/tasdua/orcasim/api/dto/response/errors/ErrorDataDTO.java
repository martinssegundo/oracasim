package br.com.tasdua.orcasim.api.dto.response.errors;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDataDTO {
    private ErrorDTO data;
}
