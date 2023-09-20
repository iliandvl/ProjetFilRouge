package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;
import be.bxlforma.projetfilrouge.dal.repositories.ZoneRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository zoneRepository;


    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public Collection<ZoneEntity> findAll() {
        return this.zoneRepository.findAll();
    }

    public Optional<ZoneEntity> findOneById(int id) {
        return this.zoneRepository.findById(id);
    }

    public void insert(ZoneEntity entity) {
        this.zoneRepository.save(entity);
    }
}