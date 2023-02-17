package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
