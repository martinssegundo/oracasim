package br.com.tasdua.orcasim.api.impl;

import br.com.tasdua.orcasim.api.IInsuranceApi;
import br.com.tasdua.orcasim.api.dto.request.InsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.MessageResponseDTO;
import br.com.tasdua.orcasim.api.dto.response.ResponseInsuraceDTO;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/insurance/budget")
public class InsuranceApi implements IInsuranceApi {

    @Value("${age.risk.start}")
    private int ageRiskStarter;
    @Value("${age.risk.final}")
    private int ageRiskFinal;
    @Value("${default.percent.insurance.starter}")
    private int defaulPercentInsuramce;

    private ICreateNewInsurance newInsuramceUserCase;
    private InsuranceMapper insuranceMapper;

    @Autowired
    public InsuranceApi(ICreateNewInsurance newInsuramceUserCase,
                        InsuranceMapper insuranceMapper) {
        this.newInsuramceUserCase = newInsuramceUserCase;
        this.insuranceMapper = insuranceMapper;
    }


    @PostMapping
    public ResponseEntity<ResponseInsuraceDTO> createNewInsurance(@RequestBody InsuranceDTO insuranceDTO) throws InsuranceException {
        var insuranceSummary = insuranceMapper.convcertToInsuranceSummary(
                newInsuramceUserCase
                        .newInsurance(insuranceMapper.convcertToInsurance(insuranceDTO),
                                defaulPercentInsuramce,
                                ageRiskStarter,
                                ageRiskFinal)
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseInsuraceDTO.builder()
                        .data(insuranceSummary)
                        .build());
    }

    @GetMapping("/{insurance}")
    public ResponseEntity<ResponseInsuraceDTO> findInsuranceById(@PathParam("insuranceId") Long insuranceId) {

        return null;
    }

    @PostMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> updateInsurance(@PathParam("insuranceId") Long insuranceId,
                                                              @RequestBody InsuranceDTO insuranceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento atualizado com sucesso")
                        .build());
    }


    @DeleteMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> deleteInsurance(@PathParam("insuranceId") Long insuranceId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento deletado com sucesso")
                        .build());
    }

}
