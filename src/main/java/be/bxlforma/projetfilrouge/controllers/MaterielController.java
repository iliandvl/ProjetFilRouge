package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.MaterielService;
import be.bxlforma.projetfilrouge.dal.entities.MaterielEntity;
import be.bxlforma.projetfilrouge.controllers.models.Materiel;

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
@RequestMapping(path = {"/Materiels"})
public class MaterielController {
    private final MaterielService materielService;

    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Materiel>> getAllAction() {
        Collection<MaterielEntity> response = this.materielService.findAll();

        List<Materiel> materielList = response.stream()
                .map(Materiel::fromEntity)
                .toList();

        return ResponseEntity.ok(materielList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Materiel> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        MaterielEntity entity = this.materielService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Materiel.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Materiel> postMaterielAction(
            @Valid @RequestBody Materiel form
    ) {
        MaterielEntity entity = form.toEntity();

        this.materielService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Materiel.fromEntity(entity));
    }

}