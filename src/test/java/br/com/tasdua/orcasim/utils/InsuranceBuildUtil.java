package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.repository.entities.InsuranceEntity;

import java.time.LocalDateTime;

public class InsuranceBuildUtil {

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver18AndDriverWithClaim() {
        var car = CarBuilderUtil.buildCarWithClaimsAndMainDriver18WithClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithClaim() {
        var car = CarBuilderUtil.buildCarWithClaimsAndMainDriver36WithClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithCarClaimsAndDriver36AndDriverWithoutClaim() {
        var car = CarBuilderUtil.buildCarWithClaimsAndMainDriver36WithoutClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }


    public static Insurance buildNewInsuranceWithoutCarClaimsAndDriver36AndDriverWithoutClaim() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithoutClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }


    public static Insurance buildNewInsuranceWithoutCarClaimsAndDriver36WithoutCustumerAndDriverWithoutClaim() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithCustumerWithoutClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithoutCarClaimsAndMainDriver36AndCustumerAndDriverWithoutClaim() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithoutClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static Insurance buildNewInsuranceWithoutCarClaimsAndMainDriver36AndWithoutCustumerAndDriverWithoutClaim() {
        var car = CarBuilderUtil.buildCarWithoutClaimsAndMainDriver36WithoutClaims();
        return Insurance.builder()
                .active(true)
                .car(car)
                .build();
    }

    public static InsuranceEntity buildNewInsuranceEntityWithoutCarClaimsAndDriver36AndDriverWithoutClaimWithID() {
        return InsuranceEntity.builder()
                .id(1L)
                .active(true)
                .car(CarBuilderUtil.buildCarEntityWithID())
                .custumer(CustumerBuilderUtil.buildCustumerEntity())
                .creationDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
