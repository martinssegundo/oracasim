package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity,Long> {
}
