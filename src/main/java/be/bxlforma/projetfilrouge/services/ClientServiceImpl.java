package be.bxlforma.projetfilrouge.services;

import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;
import be.bxlforma.projetfilrouge.dal.repositories.ClientRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Collection<ClientEntity> findAll() {
        return this.clientRepository.findAll();
    }

    public Optional<ClientEntity> findOneById(int id) {
        return this.clientRepository.findById(id);
    }

    public void insert(ClientEntity entity) {
        this.clientRepository.save(entity);
    }
}