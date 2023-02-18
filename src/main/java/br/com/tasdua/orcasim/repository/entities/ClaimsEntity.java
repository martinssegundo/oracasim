package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "claims")
@SequenceGenerator(name = "seqClaims",
        sequenceName = "seqClaims",
        initialValue = 1, allocationSize = 1)
public class ClaimsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClaims")
    private Long id;


    @Column(name = "event_date")
    private LocalDate claimDate;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private DriverEntity driver;
}
