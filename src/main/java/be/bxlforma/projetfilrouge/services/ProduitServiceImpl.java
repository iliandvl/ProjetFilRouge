package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;
import be.bxlforma.projetfilrouge.dal.repositories.ProduitRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;


    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Collection<ProduitEntity> findAll() {
        return this.produitRepository.findAll();
    }

    public Optional<ProduitEntity> findOneById(int id) {
        return this.produitRepository.findById(id);
    }

    public void insert(ProduitEntity entity) {
        this.produitRepository.save(entity);
    }
}