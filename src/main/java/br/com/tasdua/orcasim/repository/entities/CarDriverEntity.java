package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "car_drivers")
@SequenceGenerator(name = "seqCarDrivers",
        sequenceName = "seqCarDrivers",
        initialValue = 1, allocationSize = 1)
public class CarDriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCarDrivers")
    private Long id;

    @Column(name = "is_main_driver")
    private boolean mainDriver;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;
    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private DriverEntity driver;
}
