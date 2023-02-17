package br.com.tasdua.orcasim.api;

import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.MessageResponseDTO;
import br.com.tasdua.orcasim.api.dto.response.ResponseInsuraceDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/insurance/budget")
public class InsuranceApi {

    

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createNewInsurance(@RequestBody InsuranceDTO insuranceDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento cadastrado com sucesso")
                        .build());
    }

    @GetMapping("/{insurance}")
    public ResponseEntity<ResponseInsuraceDTO> findInsuranceById(@PathParam("insuranceId") Long insuranceId){

    }

    @PostMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> updateInsurance(@PathParam("insuranceId") Long insuranceId,
                                             @RequestBody InsuranceDTO insuranceDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento atualizado com sucesso")
                        .build());
    }


    @DeleteMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> deleteInsurance(@PathParam("insuranceId") Long insuranceId){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento deletado com sucesso")
                        .build());
    }

}
