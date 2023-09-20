package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.MaterielEntity;
import be.bxlforma.projetfilrouge.dal.repositories.MaterielRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class MaterielServiceImpl implements MaterielService {
    private final MaterielRepository materielRepository;


    public MaterielServiceImpl(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public Collection<MaterielEntity> findAll() {
        return this.materielRepository.findAll();
    }

    public Optional<MaterielEntity> findOneById(int id) {
        return this.materielRepository.findById(id);
    }

    public void insert(MaterielEntity entity) {
        this.materielRepository.save(entity);
    }
}