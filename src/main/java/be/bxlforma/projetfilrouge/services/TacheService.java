package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.TacheEntity;

import java.util.Optional;
import java.util.Collection;

public interface TacheService {
    Collection<TacheEntity> findAll();
    Optional<TacheEntity> findOneById(int id);

    void insert(TacheEntity entity);
}