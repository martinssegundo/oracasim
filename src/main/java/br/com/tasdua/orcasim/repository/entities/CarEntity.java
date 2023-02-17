package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "cars")
@SequenceGenerator(name = "seqCars",
        sequenceName = "seqCars",
        initialValue = 1, allocationSize = 1)
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCars")
    private Long id;

    @Column(name = "model")
    private String model;
    @Column(name = "manufactured")
    private String manufactured;
    @Column(name = "year")
    private String year;
    @Column(name = "fipe_value")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal fipeValue;

}
