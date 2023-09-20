package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.ChariotService;
import be.bxlforma.projetfilrouge.dal.entities.ChariotEntity;
import be.bxlforma.projetfilrouge.controllers.models.Chariot;

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
@RequestMapping(path = {"/Chariots"})
public class ChariotController {
    private final ChariotService chariotService;

    public ChariotController(ChariotService chariotService) {
        this.chariotService = chariotService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Chariot>> getAllAction() {
        Collection<ChariotEntity> response = this.chariotService.findAll();

        List<Chariot> chariotList = response.stream()
                .map(Chariot::fromEntity)
                .toList();

        return ResponseEntity.ok(chariotList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Chariot> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        ChariotEntity entity = this.chariotService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Chariot.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Chariot> postChariotAction(
            @Valid @RequestBody Chariot form
    ) {
        ChariotEntity entity = form.toEntity();

        this.chariotService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Chariot.fromEntity(entity));
    }

}