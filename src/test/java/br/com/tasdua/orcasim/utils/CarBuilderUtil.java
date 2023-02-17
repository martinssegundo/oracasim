package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.domain.entities.Car;

import java.time.LocalDate;
import java.util.List;

public class CarBuilderUtil {

    public static Car buildCarWithClaimsAndMainDriver18WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufacturer("Ford")
                .drivers(List.of(DriverBuilderUtils.buildMainDriver18WithClains()))
                .claims(List.of(LocalDate.now()))
                .build();
    }


    public static Car buildCarWithClaimsAndMainDriver36WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufacturer("Ford")
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithClains()))
                .claims(List.of(LocalDate.now()))
                .build();
    }


    public static Car buildCarWithoutClaimsAndMainDriver36WithClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufacturer("Ford")
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithClains()))
                .build();
    }

    public static Car buildCarWithoutClaimsAndMainDriver36WithoutClaims(){
        return Car.builder()
                .year("2020")
                .model("Focus")
                .manufacturer("Ford")
                .drivers(List.of(DriverBuilderUtils.buildMainDriver36WithoutClains()))
                .build();
    }
}
