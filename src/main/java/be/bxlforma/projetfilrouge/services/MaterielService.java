package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.MaterielEntity;

import java.util.Optional;
import java.util.Collection;

public interface MaterielService {
    Collection<MaterielEntity> findAll();
    Optional<MaterielEntity> findOneById(int id);

    void insert(MaterielEntity entity);
}