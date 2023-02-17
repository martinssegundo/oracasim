package br.com.tasdua.orcasim.repository;

import br.com.tasdua.orcasim.repository.entities.CustumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<CustumerEntity,Long> {
}
