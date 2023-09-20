package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.StagiaireEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Stagiaire {

    private Integer id;
    private String firstName;
    @NotBlank
    private String lastName;

    public static Stagiaire fromEntity(StagiaireEntity entity) {
        Stagiaire.StagiaireBuilder builder = new StagiaireBuilder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName());

        return builder.build();
    }

    public StagiaireEntity toEntity() {
        StagiaireEntity entity = new StagiaireEntity();
        entity.setFirstName(entity.getFirstName());
        entity.setLastName(entity.getLastName());
        return entity;
    }
}