package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.TacheService;
import be.bxlforma.projetfilrouge.dal.entities.TacheEntity;
import be.bxlforma.projetfilrouge.controllers.models.Tache;

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
@RequestMapping(path = {"/Taches"})
public class TacheController {
    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Tache>> getAllAction() {
        Collection<TacheEntity> response = this.tacheService.findAll();

        List<Tache> tacheList = response.stream()
                .map(Tache::fromEntity)
                .toList();

        return ResponseEntity.ok(tacheList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tache> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        TacheEntity entity = this.tacheService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Tache.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Tache> postTacheAction(
            @Valid @RequestBody Tache form
    ) {
        TacheEntity entity = form.toEntity();

        this.tacheService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Tache.fromEntity(entity));
    }

}