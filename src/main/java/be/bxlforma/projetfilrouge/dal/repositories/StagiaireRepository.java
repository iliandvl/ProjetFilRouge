package be.bxlforma.projetfilrouge.dal.repositories;

import be.bxlforma.projetfilrouge.dal.entities.StagiaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends JpaRepository<StagiaireEntity, Integer> {
}