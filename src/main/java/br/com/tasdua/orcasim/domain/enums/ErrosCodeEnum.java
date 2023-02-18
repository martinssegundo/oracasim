package br.com.tasdua.orcasim.domain.enums;

public enum ErrosCodeEnum {
    CUSTUMER_NOT_FOUND("CU01", "No custumer indentified"),
    CAR_NOT_FOUND("CA01", "No car indentified"),
    DRIVE_NOT_FOUND("DR01", "No drivers indentified"),
    INSURANCE_NOT_FOUND("IN01", "No insurance  indentified");


    private String code;
    private String mesage;

    private ErrosCodeEnum(String code, String mesage){
        this.code = code;
        this.mesage = mesage;
    }

    public String getCode() {
        return code;
    }

    public String getMesage() {
        return mesage;
    }
}
