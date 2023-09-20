package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.PhotoEntity;
import be.bxlforma.projetfilrouge.dal.repositories.PhotoRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;


    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Collection<PhotoEntity> findAll() {
        return this.photoRepository.findAll();
    }

    public Optional<PhotoEntity> findOneById(int id) {
        return this.photoRepository.findById(id);
    }

    public void insert(PhotoEntity entity) {
        this.photoRepository.save(entity);
    }
}