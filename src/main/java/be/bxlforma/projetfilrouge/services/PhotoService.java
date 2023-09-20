package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.PhotoEntity;

import java.util.Optional;
import java.util.Collection;

public interface PhotoService {
    Collection<PhotoEntity> findAll();
    Optional<PhotoEntity> findOneById(int id);

    void insert(PhotoEntity entity);
}