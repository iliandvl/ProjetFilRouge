package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;

import java.util.Optional;
import java.util.Collection;

public interface ClientService {
    Collection<ClientEntity> findAll();
    Optional<ClientEntity> findOneById(int id);

    void insert(ClientEntity entity);
}