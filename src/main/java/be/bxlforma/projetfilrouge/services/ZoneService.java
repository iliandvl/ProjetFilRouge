package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;

import java.util.Optional;
import java.util.Collection;

public interface ZoneService {
    Collection<ZoneEntity> findAll();
    Optional<ZoneEntity> findOneById(int id);

    void insert(ZoneEntity entity);
}