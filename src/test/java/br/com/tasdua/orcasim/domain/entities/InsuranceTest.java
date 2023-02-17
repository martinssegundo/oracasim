package br.com.tasdua.orcasim.domain.entities;

import br.com.tasdua.orcasim.utils.InsuranceBuildUtil;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceTest {

    @Test
    public void calculateNewInsuranceWithCarClainsAndMainDriver18WithClains(){
        var insurance = InsuranceBuildUtil.buildNewInsuranceWithCarClaimsAndDriver18AndDriverWithClaim();

        assertEquals(
                insurance.calculateValue(6,18,25),
                new BigDecimal(10290.04).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void calculateNewInsuranceWithCarClainsAndMainDriver36WithClains(){
        var insurance = InsuranceBuildUtil.buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithClaim();

        assertEquals(
                insurance.calculateValue(6,18,25),
                new BigDecimal(8575.04).setScale(2, RoundingMode.HALF_UP));
    }


    @Test
    public void calculateNewInsuranceWithCarClainsAndMainDriver36WithoutClains(){
        var insurance = InsuranceBuildUtil.buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithoutClaim();

        assertEquals(
                insurance.calculateValue(6,18,25),
                new BigDecimal(6860.03).setScale(2, RoundingMode.HALF_UP));
    }


    @Test
    public void calculateNewInsuranceWithoutCarClainsAndMainDriver36WithoutClains(){
        var insurance = InsuranceBuildUtil.buildNewInsuranceWithoutCarClaimsAndDriver36AndDriverWithoutClaim();

        assertEquals(
                insurance.calculateValue(6,18,25),
                new BigDecimal(5145.02).setScale(2, RoundingMode.HALF_UP));
    }


}

