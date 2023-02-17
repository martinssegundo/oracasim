package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class InsuranceBuildUtil {

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver18AndDriverWithClaim() {
        var car = Car.builder()
                .claims(List.of(LocalDate.now()))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver18WithClains()))
                .fipeValue(new BigDecimal(85750.35))
                .manufacturer("FORD")
                .model("FOCUS")
                .year("2021")
                .build();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithClaim() {
        var car = Car.builder()
                .claims(List.of(LocalDate.now()))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithClains()))
                .fipeValue(new BigDecimal(85750.35))
                .manufacturer("FORD")
                .model("FOCUS")
                .year("2021")
                .build();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithoutClaim() {
        var car = Car.builder()
                .claims(List.of(LocalDate.now()))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithoutClains()))
                .fipeValue(new BigDecimal(85750.35))
                .manufacturer("FORD")
                .model("FOCUS")
                .year("2021")
                .build();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }


    public static Insurance buildNewInsuranceWithoutCarClaimsAndDriver36AndDriverWithoutClaim() {
        var car = Car.builder()
                .drivers(List.of(
                                Driver.builder()
                                        .name("Luiz")
                                        .document("123456")
                                        .bithday(LocalDate.of(1987, Month.FEBRUARY,10))
                                        .build()
                        )
                )
                .fipeValue(new BigDecimal(85750.35))
                .manufacturer("FORD")
                .model("FOCUS")
                .year("2021")
                .build();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }
}
