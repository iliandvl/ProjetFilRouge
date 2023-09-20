package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;
import be.bxlforma.projetfilrouge.dal.entities.TravailEntity;
import be.bxlforma.projetfilrouge.dal.repositories.TravailRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class TravailServiceImpl implements TravailService {
    private final TravailRepository travailRepository;


    public TravailServiceImpl(TravailRepository travailRepository) {
        this.travailRepository = travailRepository;
    }

    public Collection<TravailEntity> findAll() {
        return this.travailRepository.findAll();
    }

    public Optional<TravailEntity> findOneById(int id) {
        return this.travailRepository.findById(id);
    }

    public void insert(TravailEntity entity) {
        this.travailRepository.save(entity);
    }
    
}