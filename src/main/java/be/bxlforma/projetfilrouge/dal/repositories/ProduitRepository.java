package be.bxlforma.projetfilrouge.dal.repositories;

import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Integer> {
}