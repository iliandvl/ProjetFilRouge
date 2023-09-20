package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.MaterielEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Materiel {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Materiel fromEntity(MaterielEntity entity) {
        Materiel.MaterielBuilder builder = new Materiel.MaterielBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public MaterielEntity toEntity() {
        MaterielEntity entity = new MaterielEntity();
        entity.setName(getName());
        return entity;
    }
}