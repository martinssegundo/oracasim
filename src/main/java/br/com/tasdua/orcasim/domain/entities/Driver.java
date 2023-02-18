package br.com.tasdua.orcasim.domain.entities;

import java.time.LocalDate;
import java.util.List;

public class Driver {
    private Long id;
    private String name;
    private String document;
    private LocalDate bithday;
    private boolean mainDriver;
    private boolean custumer;
    private List<Claim> claims;

    private Driver(Builder builder) {
        id = builder.id;
        name = builder.name;
        document = builder.document;
        bithday = builder.bithday;
        mainDriver = builder.mainDriver;
        custumer = builder.custumer;
        claims = builder.claims;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean hasNoClaim(){
        return mainDriver
                && (claims == null
                || claims.isEmpty());
    }

    public boolean checkAgeBetween(int startAge, int finalAge){
        var calculatedAge = calculateAge();
        return calculatedAge >= startAge && calculatedAge <= finalAge;
    }

    public int calculateAge(){
        return LocalDate.now().getYear() - bithday.getYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBithday() {
        return bithday;
    }

    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }

    public boolean isMainDriver() {
        return mainDriver;
    }

    public void setMainDriver(boolean mainDriver) {
        this.mainDriver = mainDriver;
    }

    public boolean isCustumer() {
        return custumer;
    }

    public void setCustumer(boolean custumer) {
        this.custumer = custumer;
    }

    public List<Claim> getClaims() {
        if(claims == null)
            claims = List.of();
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String document;
        private LocalDate bithday;
        private boolean mainDriver;
        private boolean custumer;
        private List<Claim> claims;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder document(String val) {
            document = val;
            return this;
        }

        public Builder bithday(LocalDate val) {
            bithday = val;
            return this;
        }

        public Builder mainDriver(boolean val) {
            mainDriver = val;
            return this;
        }

        public Builder custumer(boolean val) {
            custumer = val;
            return this;
        }

        public Builder claims(List<Claim> val) {
            claims = val;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}
