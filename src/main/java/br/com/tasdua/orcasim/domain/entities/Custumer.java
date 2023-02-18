package br.com.tasdua.orcasim.domain.entities;

public class Custumer {
    private Long id;
    private String name;

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

    private Custumer(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private String name;

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

        public Custumer build() {
            return new Custumer(this);
        }
    }
}
