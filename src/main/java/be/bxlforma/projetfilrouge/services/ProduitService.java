package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;

import java.util.Optional;
import java.util.Collection;

public interface ProduitService {
    Collection<ProduitEntity> findAll();
    Optional<ProduitEntity> findOneById(int id);

    void insert(ProduitEntity entity);
}