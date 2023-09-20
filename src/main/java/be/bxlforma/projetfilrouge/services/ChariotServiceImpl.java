package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ChariotEntity;
import be.bxlforma.projetfilrouge.dal.repositories.ChariotRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class ChariotServiceImpl implements ChariotService {
    private final ChariotRepository chariotRepository;


    public ChariotServiceImpl(ChariotRepository chariotRepository) {
        this.chariotRepository = chariotRepository;
    }

    public Collection<ChariotEntity> findAll() {
        return this.chariotRepository.findAll();
    }

    public Optional<ChariotEntity> findOneById(int id) {
        return this.chariotRepository.findById(id);
    }

    public void insert(ChariotEntity entity) {
        this.chariotRepository.save(entity);
    }
}