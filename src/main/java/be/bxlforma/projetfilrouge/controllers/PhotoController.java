package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.PhotoService;
import be.bxlforma.projetfilrouge.dal.entities.PhotoEntity;
import be.bxlforma.projetfilrouge.controllers.models.Photo;

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
@RequestMapping(path = {"/Photos"})
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Photo>> getAllAction() {
        Collection<PhotoEntity> response = this.photoService.findAll();

        List<Photo> photoList = response.stream()
                .map(Photo::fromEntity)
                .toList();

        return ResponseEntity.ok(photoList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Photo> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        PhotoEntity entity = this.photoService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Photo.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Photo> postPhotoAction(
            @Valid @RequestBody Photo form
    ) {
        PhotoEntity entity = form.toEntity();

        this.photoService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Photo.fromEntity(entity));
    }

}