package br.com.tasdua.orcasim.api.handlers;

import br.com.tasdua.orcasim.api.dto.response.errors.ErrorDTO;
import br.com.tasdua.orcasim.api.dto.response.errors.ErrorDataDTO;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class InsuranceHandlerErro extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InsuranceException.class)
    protected ResponseEntity<ErrorDataDTO> handleInsuranceException(InsuranceException insuranceException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDataDTO.builder()
                        .data(ErrorDTO.builder()
                                .code(insuranceException.getCode())
                                .mesage(insuranceException.getMessage())
                                .build())
                        .build());
    }
}
