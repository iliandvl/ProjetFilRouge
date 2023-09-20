package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.ZoneService;
import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;
import be.bxlforma.projetfilrouge.controllers.models.Zone;

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
@RequestMapping(path = {"/Zones"})
public class ZoneController {
    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Zone>> getAllAction() {
        Collection<ZoneEntity> response = this.zoneService.findAll();

        List<Zone> zoneList = response.stream()
                .map(Zone::fromEntity)
                .toList();

        return ResponseEntity.ok(zoneList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Zone> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        ZoneEntity entity = this.zoneService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Zone.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Zone> postZoneAction(
            @Valid @RequestBody Zone form
    ) {
        ZoneEntity entity = form.toEntity();

        this.zoneService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Zone.fromEntity(entity));
    }

}