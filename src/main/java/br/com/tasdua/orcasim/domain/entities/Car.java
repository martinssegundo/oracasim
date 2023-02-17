package br.com.tasdua.orcasim.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    private String model;
    private String manufacturer;
    private String year;
    private BigDecimal fipeValue;
    private List<LocalDate> claims;
    private List<Driver> drivers;

    public boolean hasNoClaim(){
        return claims == null || claims.isEmpty();
    }

    public int varifyMainDriversHasRisk(int startAgeWithRisk, int finalAgeWithRisk){
        var totalRisk = 0;
        AtomicInteger ageRisk = new AtomicInteger();
        AtomicInteger clainsRisk = new AtomicInteger();
        drivers.stream()
                .filter(driver -> driver.isMainDriver())
                .forEach(driver -> {
                    if(driver.checkAgeBetween(startAgeWithRisk,finalAgeWithRisk))
                        ageRisk.addAndGet(1);
                    if(!driver.hasNoClaim())
                        clainsRisk.addAndGet(1);
                });

        if(ageRisk.getAcquire() > 0)
            totalRisk += 2;
        if(clainsRisk.getAcquire() > 0)
            totalRisk += 2;

        return totalRisk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getFipeValue() {
        return fipeValue;
    }

    public void setFipeValue(BigDecimal fipeValue) {
        this.fipeValue = fipeValue;
    }

    public List<LocalDate> getClaims() {
        return claims;
    }

    public void setClaims(List<LocalDate> claims) {
        this.claims = claims;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    private Car(Builder builder) {
        model = builder.model;
        manufacturer = builder.manufacturer;
        year = builder.year;
        fipeValue = builder.fipeValue;
        claims = builder.claims;
        drivers = builder.drivers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String model;
        private String manufacturer;
        private String year;
        private BigDecimal fipeValue;
        private List<LocalDate> claims;
        private List<Driver> drivers;

        private Builder() {
        }

        public Builder model(String val) {
            model = val;
            return this;
        }

        public Builder manufacturer(String val) {
            manufacturer = val;
            return this;
        }

        public Builder year(String val) {
            year = val;
            return this;
        }

        public Builder fipeValue(BigDecimal val) {
            fipeValue = val;
            return this;
        }

        public Builder claims(List<LocalDate> val) {
            claims = val;
            return this;
        }

        public Builder drivers(List<Driver> val) {
            drivers = val;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
