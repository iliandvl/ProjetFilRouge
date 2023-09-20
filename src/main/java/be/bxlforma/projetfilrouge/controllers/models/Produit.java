package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.ProduitEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Produit {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Produit fromEntity(ProduitEntity entity) {
        Produit.ProduitBuilder builder = new Produit.ProduitBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public ProduitEntity toEntity() {
        ProduitEntity entity = new ProduitEntity();
        entity.setName(getName());
        return entity;
    }
}