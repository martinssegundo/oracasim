package br.com.tasdua.orcasim.domain.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Insurance {

    private Car car;
    private boolean active;

    private Insurance(Builder builder) {
        car = builder.car;
        active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigDecimal calculateValue(int startValueInsurance,
                                     int startAgeWithRisk,
                                     int finalAgeWithRisk) {
        float driverRiskValueToAdd = car.varifyMainDriversHasRisk(startAgeWithRisk,finalAgeWithRisk);
        float carRiskToAdd = car.hasNoClaim()?0:2;
        var totalRisk = (startValueInsurance+driverRiskValueToAdd+carRiskToAdd)/100;
        var multiplyer = new BigDecimal(totalRisk).setScale(2, RoundingMode.HALF_UP);
        return car.getFipeValue().multiply(multiplyer).setScale(2, RoundingMode.HALF_UP);
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static final class Builder {
        private Car car;
        private boolean active;

        private Builder() {
        }

        public Builder car(Car val) {
            car = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Insurance build() {
            return new Insurance(this);
        }
    }
}
