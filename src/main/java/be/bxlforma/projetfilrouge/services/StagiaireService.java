package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.StagiaireEntity;

import java.util.Optional;
import java.util.Collection;

public interface StagiaireService {
    Collection<StagiaireEntity> findAll();
    Optional<StagiaireEntity> findOneById(int id);

    void insert(StagiaireEntity entity);
}