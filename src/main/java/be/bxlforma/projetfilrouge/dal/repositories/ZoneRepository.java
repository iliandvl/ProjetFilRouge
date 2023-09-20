package be.bxlforma.projetfilrouge.dal.repositories;

import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<ZoneEntity, Integer> {
}