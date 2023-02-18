package br.com.tasdua.orcasim.domain.excptions;

public class InsuranceException extends Exception{

    private String code;
    public InsuranceException(String code, String mesage){
        super(mesage);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
