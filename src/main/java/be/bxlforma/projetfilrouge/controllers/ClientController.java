package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.ClientService;
import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;
import be.bxlforma.projetfilrouge.controllers.models.Client;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/Clients"})
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Client>> getAllAction() {
        Collection<ClientEntity> response = this.clientService.findAll();

        List<Client> clientList = response.stream()
                .map(Client::fromEntity)
                .toList();

        return ResponseEntity.ok(clientList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Client> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        ClientEntity entity = this.clientService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Client.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Client> postClientAction(
            @Valid @RequestBody Client form
    ) {
        ClientEntity entity = form.toEntity();

        this.clientService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Client.fromEntity(entity));
    }

}