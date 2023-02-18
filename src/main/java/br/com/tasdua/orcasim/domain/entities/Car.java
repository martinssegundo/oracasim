package br.com.tasdua.orcasim.domain.entities;

import br.com.tasdua.orcasim.domain.excptions.CustumerNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    private Long id;
    private String model;
    private String manufactured;
    private String year;
    private BigDecimal fipeValue;
    private List<Claim> claims;
    private List<Driver> drivers;

    private Car(Builder builder) {
        id = builder.id;
        model = builder.model;
        manufactured = builder.manufactured;
        year = builder.year;
        fipeValue = builder.fipeValue;
        claims = builder.claims;
        drivers = builder.drivers;
    }

    public static Builder builder() {
        return new Builder();
    }


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

    public Driver findCustumer() throws CustumerNotFoundException {
        var driverFinded = drivers.stream()
                .filter(driver -> driver.isCustumer())
                .findFirst();
        return driverFinded.orElseThrow(() -> new CustumerNotFoundException());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
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

    public List<Claim> getClaims() {
        if(claims == null)
            claims = List.of();
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public List<Driver> getDrivers() {
        if(drivers == null)
            drivers = List.of();
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public static final class Builder {
        private Long id;
        private String model;
        private String manufactured;
        private String year;
        private BigDecimal fipeValue;
        private List<Claim> claims;
        private List<Driver> drivers;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder model(String val) {
            model = val;
            return this;
        }

        public Builder manufactured(String val) {
            manufactured = val;
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

        public Builder claims(List<Claim> val) {
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
