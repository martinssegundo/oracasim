package br.com.tasdua.orcasim.domain.entities;

import br.com.tasdua.orcasim.utils.CarBuilderUtil;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testHasNoClaimTrue() {
        var car = CarBuilderUtil
                .buildCarWithoutClaimsAndMainDriver36WithoutClaims();
        assertTrue(car.hasNoClaim());
    }

    @Test
    void testHasNoClaimFalse() {
        var car = CarBuilderUtil
                .buildCarWithClaimsAndMainDriver18WithClaims();
        assertFalse(car.hasNoClaim());
    }

    @Test
    void testVarifyMainDriversHasRiskWithAllRisks() {
        var car = CarBuilderUtil.buildCarWithClaimsAndMainDriver18WithClaims();
        assertEquals(4,
                car.varifyMainDriversHasRisk(18,25));
    }

    @Test
    void testVarifyMainDriversHasRiskWithNoRisks() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithoutClaims();
        assertEquals(0,
                car.varifyMainDriversHasRisk(18,25));
    }

    @Test
    void testVarifyMainDriversHasRiskWithOneRisks() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithClaims();
        assertEquals(2,
                car.varifyMainDriversHasRisk(18,25));
    }

}