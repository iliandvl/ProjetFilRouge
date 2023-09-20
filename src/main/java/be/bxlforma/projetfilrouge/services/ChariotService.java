package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ChariotEntity;

import java.util.Optional;
import java.util.Collection;

public interface ChariotService {
    Collection<ChariotEntity> findAll();
    Optional<ChariotEntity> findOneById(int id);

    void insert(ChariotEntity entity);
}