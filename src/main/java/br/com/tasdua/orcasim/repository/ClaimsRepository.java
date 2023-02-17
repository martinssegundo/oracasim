package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.ClaimsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsRepository extends JpaRepository<ClaimsEntity,Long> {
}
