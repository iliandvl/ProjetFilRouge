package be.bxlforma.projetfilrouge.dal.repositories;

import be.bxlforma.projetfilrouge.dal.entities.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {
}