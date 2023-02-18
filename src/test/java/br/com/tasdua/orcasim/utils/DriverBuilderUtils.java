package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.repository.entities.DriverEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DriverBuilderUtils {

    public static Driver buildMainDriver18WithClains(){
        return  Driver.builder()
                .name("Luiz")
                .document("123456")
                .bithday(LocalDate.of(LocalDate.now().getYear()-18, Month.FEBRUARY,10))
                .claims(List.of(LocalDate.now()))
                .mainDriver(true)
                .build();
    }

    public static Driver buildMainDriver36WithClains(){
        return  Driver.builder()
                .name("Luiz")
                .document("123456")
                .bithday(LocalDate.of(LocalDate.now().getYear()-36, Month.FEBRUARY,10))
                .claims(List.of(LocalDate.now()))
                .mainDriver(true)
                .build();
    }


    public static Driver buildMainDriver36WithoutClains(){
        return  Driver.builder()
                .name("Luiz")
                .document("123456")
                .bithday(LocalDate.of(LocalDate.now().getYear()-36, Month.FEBRUARY,10))
                .mainDriver(true)
                .custumer(true)
                .build();
    }


    public static Driver buildMainDriver36WithoutClainsWithID(){
        return  Driver.builder()
                .id(1L)
                .name("Luiz")
                .document("123456")
                .bithday(LocalDate.of(LocalDate.now().getYear()-36, Month.FEBRUARY,10))
                .mainDriver(true)
                .custumer(true)
                .build();
    }

    public static Driver buildMainDriver36WithoutCustumerWithoutClainsWithID(){
        return  Driver.builder()
                .id(1L)
                .name("Luiz")
                .document("123456")
                .bithday(LocalDate.of(LocalDate.now().getYear()-36, Month.FEBRUARY,10))
                .mainDriver(true)
                .custumer(false)
                .build();
    }


    public static DriverEntity buildMainDriverEntity36WithoutClainsWithID(){
        return  DriverEntity.builder()
                .id(1L)
                .document("123456")
                .bithdate(LocalDate.of(LocalDate.now().getYear()-36, Month.FEBRUARY,10))
                .build();
    }
}
