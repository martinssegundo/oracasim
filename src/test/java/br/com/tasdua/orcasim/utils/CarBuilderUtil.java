package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.repository.entities.CarEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CarBuilderUtil {

    public static Car buildCarWithClaimsAndMainDriver18WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver18WithClains()))
                .claims(List.of(LocalDate.now()))
                .build();
    }


    public static Car buildCarWithClaimsAndMainDriver36WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithClains()))
                .claims(List.of(LocalDate.now()))
                .build();
    }

    public static Car buildCarWithClaimsAndMainDriver36WithoutClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithoutClains()))
                .claims(List.of(LocalDate.now()))
                .build();
    }


    public static Car buildCarWithoutClaimsAndMainDriver36WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithClains()))
                .build();
    }

    public static Car buildCarWithoutClaimsAndMainDriver36WithoutClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithoutClainsWithID()))
                .build();
    }

    public static Car buildCarWithoutClaimsAndMainDriver36WithCustumerWithoutClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithoutCustumerWithoutClainsWithID()))
                .build();
    }

    public static CarEntity buildCarEntityWithID(){
        return CarEntity.builder()
                .id(1L)
                .year("2020")
                .model("Focus")
                .manufactured("Ford")
                .fipeValue(new BigDecimal(85750.35))
                .build();
    }
}
