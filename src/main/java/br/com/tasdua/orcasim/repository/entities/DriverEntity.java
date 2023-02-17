package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "drivers")
@SequenceGenerator(name = "seqDrivers",
        sequenceName = "seqDrivers",
        initialValue = 1, allocationSize = 1)
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDrivers")
    private Long id;

    @Column(name = "document")
    private String document;

    @Column(name = "bithdate")
    @Temporal(TemporalType.DATE)
    private LocalDate bithdate;

}
