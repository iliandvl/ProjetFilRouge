package be.bxlforma.projetfilrouge.controllers;

import be.bxlforma.projetfilrouge.services.ProduitService;
import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;
import be.bxlforma.projetfilrouge.controllers.models.Produit;

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
@RequestMapping(path = {"/Produits"})
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Produit>> getAllAction() {
        Collection<ProduitEntity> response = this.produitService.findAll();

        List<Produit> produitList = response.stream()
                .map(Produit::fromEntity)
                .toList();

        return ResponseEntity.ok(produitList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Produit> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        ProduitEntity entity = this.produitService.findOneById(id)
                .orElseThrow();

        return ResponseEntity.ok(Produit.fromEntity(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<Produit> postProduitAction(
            @Valid @RequestBody Produit form
    ) {
        ProduitEntity entity = form.toEntity();

        this.produitService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Produit.fromEntity(entity));
    }

}