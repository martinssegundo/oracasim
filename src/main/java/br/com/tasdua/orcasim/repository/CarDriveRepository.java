package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.CarDriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDriveRepository extends JpaRepository<CarDriverEntity, Long> {
}
