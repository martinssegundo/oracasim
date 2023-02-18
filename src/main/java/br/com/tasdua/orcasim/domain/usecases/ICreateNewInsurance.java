package br.com.tasdua.orcasim.domain.usecases;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;

public interface ICreateNewInsurance {

    Insurance create(Insurance insurance, int defaulPercentInsuramce,
                     int ageRiskStart, int ageRiskFinal) throws InsuranceException;
}
