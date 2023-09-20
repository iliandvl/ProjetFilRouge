package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.StagiaireService;
import be.bxlforma.projetfilrouge.dal.entities.StagiaireEntity;
import be.bxlforma.projetfilrouge.controllers.models.Stagiaire;

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
@RequestMapping(path = {"/Stagiaires"})
public class StagiaireController {
    private final StagiaireService stagiaireService;

    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Stagiaire>> getAllAction() {
        Collection<StagiaireEntity> response = this.stagiaireService.findAll();

        List<Stagiaire> stagiaireList = response.stream()
                .map(Stagiaire::fromEntity)
                .toList();

        return ResponseEntity.ok(stagiaireList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Stagiaire> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        StagiaireEntity entity = this.stagiaireService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Stagiaire.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Stagiaire> postStagiaireAction(
            @Valid @RequestBody Stagiaire form
    ) {
        StagiaireEntity entity = form.toEntity();

        this.stagiaireService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Stagiaire.fromEntity(entity));
    }

}