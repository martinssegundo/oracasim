package br.com.tasdua.orcasim.domain.entities;

import java.time.LocalDate;

public class Claim {
    private Long id;
    private Long car;
    private Long driver;
    private LocalDate claimDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getDriver() {
        return driver;
    }

    public void setDriver(Long driver) {
        this.driver = driver;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    private Claim(Builder builder) {
        id = builder.id;
        car = builder.car;
        driver = builder.driver;
        claimDate = builder.claimDate;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private Long car;
        private Long driver;
        private LocalDate claimDate;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder car(Long val) {
            car = val;
            return this;
        }

        public Builder driver(Long val) {
            driver = val;
            return this;
        }

        public Builder claimDate(LocalDate val) {
            claimDate = val;
            return this;
        }

        public Claim build() {
            return new Claim(this);
        }
    }
}
