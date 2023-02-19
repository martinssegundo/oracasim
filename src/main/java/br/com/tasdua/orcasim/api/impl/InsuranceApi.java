package br.com.tasdua.orcasim.api.impl;

import br.com.tasdua.orcasim.api.IInsuranceApi;
import br.com.tasdua.orcasim.api.dto.request.newInsurace.NewInsuranceDTO;
import br.com.tasdua.orcasim.api.dto.request.updateInsurance.UpdateInsuranceDTO;
import br.com.tasdua.orcasim.api.dto.response.MessageResponseDTO;
import br.com.tasdua.orcasim.api.dto.response.ResponseInsuraceDTO;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.ICreateNewInsurance;
import br.com.tasdua.orcasim.domain.usecases.IITemDelete;
import br.com.tasdua.orcasim.domain.usecases.IITemFinder;
import br.com.tasdua.orcasim.mappers.InsuranceMapper;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private IITemDelete deleteInsurance;
    private IITemFinder finderIsurance;
    private InsuranceMapper insuranceMapper;

    @Autowired
    public InsuranceApi(ICreateNewInsurance newInsuramceUserCase,
                        @Qualifier("deleteInsurance") IITemDelete deleteInsurance,
                        @Qualifier("deleteInsurance") IITemFinder finderIsurance,
                        InsuranceMapper insuranceMapper) {
        this.newInsuramceUserCase = newInsuramceUserCase;
        this.deleteInsurance = deleteInsurance;
        this.finderIsurance = finderIsurance;
        this.insuranceMapper = insuranceMapper;
    }


    @PostMapping
    public ResponseEntity<ResponseInsuraceDTO> createNewInsurance(@RequestBody NewInsuranceDTO newInsuranceDTO) throws InsuranceException {
        var insuranceSummary = insuranceMapper.convcertToInsuranceSummary(
                newInsuramceUserCase
                        .create(insuranceMapper.convcertToInsurance(newInsuranceDTO),
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

    @PutMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> updateInsurance(@PathParam("insuranceId") Long insuranceId,
                                                              @RequestBody UpdateInsuranceDTO newInsuranceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento atualizado com sucesso")
                        .build());
    }


    @DeleteMapping("/{insuranceId}")
    public ResponseEntity<MessageResponseDTO> deleteInsurance(@PathParam("insuranceId") Long insuranceId) throws Throwable {
        deleteInsurance.deleteItem(insuranceId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponseDTO.builder()
                        .data("Orcamento deletado com sucesso")
                        .build());
    }

}
