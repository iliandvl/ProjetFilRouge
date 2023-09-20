package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.TravailEntity;

import java.util.Optional;
import java.util.Collection;

public interface TravailService {
    Collection<TravailEntity> findAll();
    Optional<TravailEntity> findOneById(int id);

    void insert(TravailEntity entity);
}