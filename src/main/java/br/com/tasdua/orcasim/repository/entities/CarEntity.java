package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
@SequenceGenerator(name = "seqCars",
        sequenceName = "seqCars",
        initialValue = 1, allocationSize = 1)
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCars")
    private Long id;

    @Column(name = "models")
    private String model;
    @Column(name = "manufacturer")
    private String manufactured;
    @Column(name = "years")
    private String year;
    @Column(name = "fipe_value")
    private BigDecimal fipeValue;

}
