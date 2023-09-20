package be.bxlforma.projetfilrouge.dal.repositories;

import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}