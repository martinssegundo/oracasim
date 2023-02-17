package br.com.tasdua.orcasim.domain.entities;

import java.time.LocalDate;
import java.util.List;

public class Driver {
    private String name;
    private String document;
    private LocalDate bithday;
    private boolean mainDriver;
    private List<LocalDate> claims;

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

    public List<LocalDate> getClaims() {
        return claims;
    }

    public void setClaims(List<LocalDate> claims) {
        this.claims = claims;
    }

    public boolean isMainDriver() {
        return mainDriver;
    }

    public void setMainDriver(boolean mainDriver) {
        this.mainDriver = mainDriver;
    }


    private Driver(Builder builder) {
        setName(builder.name);
        setDocument(builder.document);
        setBithday(builder.bithday);
        mainDriver = builder.mainDriver;
        setClaims(builder.claims);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String document;
        private LocalDate bithday;
        private boolean mainDriver;
        private List<LocalDate> claims;

        private Builder() {
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

        public Builder claims(List<LocalDate> val) {
            claims = val;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}
