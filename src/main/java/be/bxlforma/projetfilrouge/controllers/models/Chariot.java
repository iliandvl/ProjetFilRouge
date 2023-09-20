package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.ChariotEntity;

import be.bxlforma.projetfilrouge.dal.entities.MaterielEntity;
import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Builder
@Setter
@Getter
public class Chariot {

    private Integer number;
    private List<Materiel> materiels;
    private List<Produit> produits;

    public static Chariot fromEntity(ChariotEntity entity) {
        Chariot.ChariotBuilder builder = new ChariotBuilder()
                .number(entity.getNumber())
                .materiels(entity.getMateriels().stream().map(Materiel::fromEntity).toList())
                .produits(entity.getProduits().stream().map(Produit::fromEntity).toList());

        return builder.build();
    }

    public ChariotEntity toEntity() {
        ChariotEntity entity = new ChariotEntity();
        entity.setMateriels(getMateriels().stream().map(Materiel::toEntity).toList());
        entity.setProduits(getProduits().stream().map(Produit::toEntity).toList());
        return entity;
    }
}