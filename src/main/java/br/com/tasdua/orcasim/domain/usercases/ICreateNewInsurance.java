package br.com.tasdua.orcasim.domain.usercases;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;

public interface ICreateNewInsurance {

    void newInsurance(Insurance insurance) throws InsuranceException;
}
