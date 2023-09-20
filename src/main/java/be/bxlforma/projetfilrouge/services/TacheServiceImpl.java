package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.TacheEntity;
import be.bxlforma.projetfilrouge.dal.repositories.TacheRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class TacheServiceImpl implements TacheService {
    private final TacheRepository tacheRepository;


    public TacheServiceImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    public Collection<TacheEntity> findAll() {
        return this.tacheRepository.findAll();
    }

    public Optional<TacheEntity> findOneById(int id) {
        return this.tacheRepository.findById(id);
    }

    public void insert(TacheEntity entity) {
        this.tacheRepository.save(entity);
    }
}