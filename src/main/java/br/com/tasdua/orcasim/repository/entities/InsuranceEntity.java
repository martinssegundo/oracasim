package br.com.tasdua.orcasim.repository.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "insurances")
@SequenceGenerator(name = "seqInsurances",
        sequenceName = "seqInsurances",
        initialValue = 1, allocationSize = 1)
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInsurances")
    private Long id;

    @Column(name = "creation_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    @Column(name = "updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private CarEntity car;

    @OneToOne
    @JoinColumn(name = "custumer_id", referencedColumnName = "id")
    private CustumerEntity custumer;

    @Column(name = "is_active")
    private Boolean active;
}
