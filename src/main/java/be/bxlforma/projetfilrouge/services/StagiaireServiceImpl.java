package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.StagiaireEntity;
import be.bxlforma.projetfilrouge.dal.repositories.StagiaireRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class StagiaireServiceImpl implements StagiaireService {
    private final StagiaireRepository stagiaireRepository;


    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public Collection<StagiaireEntity> findAll() {
        return this.stagiaireRepository.findAll();
    }

    public Optional<StagiaireEntity> findOneById(int id) {
        return this.stagiaireRepository.findById(id);
    }

    public void insert(StagiaireEntity entity) {
        this.stagiaireRepository.save(entity);
    }
}