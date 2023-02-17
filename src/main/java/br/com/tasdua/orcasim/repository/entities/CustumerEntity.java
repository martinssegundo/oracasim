package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "custumer")
@SequenceGenerator(name = "seqCustumer",
        sequenceName = "seqCustumer",
        initialValue = 1, allocationSize = 1)
public class CustumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustumer")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private DriverEntity driver;
}
