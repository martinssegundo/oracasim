package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.repository.entities.ClaimsEntity;

import java.time.LocalDate;

public class ClaimBuilderUtil {

    public static ClaimsEntity buiuldClaimEntity(){
        return ClaimsEntity.builder()
                .car(CarBuilderUtil.buildCarEntityWithID())
                .claimDate(LocalDate.now())
                .driver(DriverBuilderUtils.buildMainDriverEntity36WithoutClainsWithID())
                .build();
    }
}
