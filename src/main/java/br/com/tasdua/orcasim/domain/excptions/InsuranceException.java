package br.com.tasdua.orcasim.domain.excptions;

import br.com.tasdua.orcasim.domain.enums.ErrosCodeEnum;

public class InsuranceException extends Exception{

    private ErrosCodeEnum error;
    public InsuranceException(ErrosCodeEnum error){
        super();
        this.error = error;
    }

    public ErrosCodeEnum getError() {
        return error;
    }
}
