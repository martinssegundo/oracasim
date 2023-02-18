package br.com.tasdua.orcasim.api;

import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.MessageResponseDTO;
import br.com.tasdua.orcasim.api.dto.response.ResponseInsuraceDTO;
import br.com.tasdua.orcasim.api.dto.response.errors.ErrorDataDTO;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "insurance")
public interface IInsuranceApi {

    @Operation(summary = "Add new Insurance",
            description = "Add new Insurance with all informations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ResponseInsuraceDTO.class))),
            @ApiResponse(responseCode = "400",
                    content = @Content(schema = @Schema(implementation = ErrorDataDTO.class)))
    })
    ResponseEntity<ResponseInsuraceDTO> createNewInsurance(@RequestBody InsuranceDTO insuranceDTO) throws InsuranceException;

    @Operation
    ResponseEntity<ResponseInsuraceDTO> findInsuranceById(@PathParam("insuranceId") Long insuranceId);

    @Operation
    ResponseEntity<MessageResponseDTO> updateInsurance(@PathParam("insuranceId") Long insuranceId,
                                                       @RequestBody InsuranceDTO insuranceDTO);

    @Operation
    ResponseEntity<MessageResponseDTO> deleteInsurance(@PathParam("insuranceId") Long insuranceId);
}
