package br.com.tasdua.orcasim.api.impl;

import br.com.tasdua.orcasim.api.IInsuranceApi;
import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.MessageResponseDTO;
import br.com.tasdua.orcasim.api.dto.response.ResponseInsuraceDTO;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/insurance/budget")
public class InsuranceApi implements IInsuranceApi {

    private ICreateNewInsurance newInsuramceUserCase;
    private InsuranceMapper insuranceMapper;

    @Autowired
    public InsuranceApi(ICreateNewInsurance newInsuramceUserCase,
                        InsuranceMapper insuranceMapper){
        this.newInsuramceUserCase = newInsuramceUserCase;
        this.insuranceMapper = insuranceMapper;
    }


    @PostMapping
    public ResponseEntity<MessageResponseDTO> createNewInsurance(@RequestBody InsuranceDTO insuranceDTO) throws InsuranceException {
        newInsuramceUserCase.newInsurance(insuranceMapper.convcertTo(insuranceDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento cadastrado com sucesso")
                        .build());
    }

    @GetMapping("/{insurance}")
    public ResponseEntity<ResponseInsuraceDTO> findInsuranceById(@PathParam("insuranceId") Long insuranceId){

        return null;
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
