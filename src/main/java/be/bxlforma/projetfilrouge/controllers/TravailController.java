package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.TravailService;
import be.bxlforma.projetfilrouge.dal.entities.TravailEntity;
import be.bxlforma.projetfilrouge.controllers.models.Travail;

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
@RequestMapping(path = {"/Travails"})
public class TravailController {
    private final TravailService travailService;

    public TravailController(TravailService travailService) {
        this.travailService = travailService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Travail>> getAllAction() {
        Collection<TravailEntity> response = this.travailService.findAll();

        List<Travail> travailList = response.stream()
                .map(Travail::fromEntity)
                .toList();

        return ResponseEntity.ok(travailList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Travail> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        TravailEntity entity = this.travailService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Travail.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Travail> postTravailAction(
            @Valid @RequestBody Travail form
    ) {
        TravailEntity entity = form.toEntity();

        this.travailService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Travail.fromEntity(entity));
    }



}