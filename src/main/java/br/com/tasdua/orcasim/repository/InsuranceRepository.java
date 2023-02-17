package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
