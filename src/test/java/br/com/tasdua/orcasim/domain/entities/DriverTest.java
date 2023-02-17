package br.com.tasdua.orcasim.domain.entities;

import br.com.tasdua.orcasim.utils.DriverBuilderUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DriverTest {

    @Test
    void testHasNoClaimWithClaims() {
        var driver = DriverBuilderUtils.buildMainDriver18WithClains();
        assertFalse(driver.hasNoClaim());
    }

    @Test
    void testHasNoClaimWithoutClaims() {
        var driver = DriverBuilderUtils.buildMainDriver36WithoutClains();
        assertTrue(driver.hasNoClaim());
    }

    @Test
    void testCalculateAge() {
        var driver = DriverBuilderUtils.buildMainDriver18WithClains();
        assertEquals(18, driver.calculateAge());
    }

    @Test
    void testeAgeBetweenTrue(){
        var driver = DriverBuilderUtils.buildMainDriver18WithClains();
        assertTrue(driver.checkAgeBetween(18,30));
    }

    @Test
    void testeAgeBetweenFalse(){
        var driver = DriverBuilderUtils.buildMainDriver36WithClains();
        assertFalse(driver.checkAgeBetween(18,30));
    }
}