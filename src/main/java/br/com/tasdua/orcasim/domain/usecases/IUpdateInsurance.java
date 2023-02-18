package br.com.tasdua.orcasim.domain.usecases;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;

public interface IUpdateInsurance {

    public Insurance updateInsurance(Insurance insurance) throws InsuranceException;
}
